package com.colutti.newsapi.service.impl;

import com.colutti.newsapi.dto.NewsComment;
import com.colutti.newsapi.exception.CommentNewsApiRuntimeException;
import com.colutti.newsapi.service.IFindNewsCommentsRequestService;
import com.colutti.newsapi.util.ApplicationPropertiesReader;
import com.google.gson.Gson;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.decorators.Decorators;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public class FindNewsCommentsRequestService implements IFindNewsCommentsRequestService {

    private ApplicationPropertiesReader applicationPropertiesReader;
    private CircuitBreaker circuitBreaker;
    private Gson gson;

    private static String GET_COMMENTS_PATH="/newscomments/";
    private static String COMMENTS_API_KEY="newscommentapi.url";
    private static String COMMENT_API_CB_NAME="commentApiCircuitBreaker";

    public FindNewsCommentsRequestService(){
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .slidingWindowSize(5)
                .recordExceptions(CommentNewsApiRuntimeException.class)
                .build();
        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);
        circuitBreaker = registry.circuitBreaker(COMMENT_API_CB_NAME);
        this.applicationPropertiesReader = new ApplicationPropertiesReader();
        this.gson = new Gson();
    }

    @Override
    public List<NewsComment> getCommentsByNewsTitle(String title){
        Supplier<List<NewsComment>> flightsSupplier = () -> {
            return this.makeRequestOnCommentNewsApiToSearchComments(title);
        };
        Supplier<List<NewsComment>> decorated = Decorators
                .ofSupplier(flightsSupplier)
                .withCircuitBreaker(circuitBreaker)
                .withFallback(Arrays.asList(CallNotPermittedException.class),
                        e -> this.getEmptyCommmentNews())
                .decorate();
        return decorated.get();
    }

    private List<NewsComment> makeRequestOnCommentNewsApiToSearchComments(String title){
        try {
            String getCommentsUrl = this.applicationPropertiesReader
                    .getPropertyByName(COMMENTS_API_KEY) + GET_COMMENTS_PATH + title.replaceAll(" ", "%20");
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(getCommentsUrl))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            NewsComment[] newsCommentsListObj = gson.fromJson(response.body(), NewsComment[].class);
            return Arrays.asList(newsCommentsListObj);
        } catch (Exception e) {
            throw new CommentNewsApiRuntimeException(e.getMessage());
        }
    }

    private List<NewsComment> getEmptyCommmentNews(){
        return Collections.emptyList();
    }

}
