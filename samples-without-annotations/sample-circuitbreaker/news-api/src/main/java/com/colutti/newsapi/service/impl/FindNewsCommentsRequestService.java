package com.colutti.newsapi.service.impl;

import com.colutti.newsapi.dto.NewsComment;
import com.colutti.newsapi.service.IFindNewsCommentsRequestService;
import com.colutti.newsapi.util.ApplicationPropertiesReader;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class FindNewsCommentsRequestService implements IFindNewsCommentsRequestService {

    private ApplicationPropertiesReader applicationPropertiesReader;
    private Gson gson;

    private static String GET_COMMENTS_PATH="/newscomments/";
    private static String COMMENTS_API_KEY="newscommentapi.url";

    public FindNewsCommentsRequestService(){
        this.applicationPropertiesReader = new ApplicationPropertiesReader();
        this.gson = new Gson();
    }

    @Override
    public List<NewsComment> getCommentsByNewsTitle(String title) throws Exception {
        try {
            return makeRequestOnCommentNewsApiToSearchComments(title);
        }catch (Exception e){
            throw new Exception(e.getMessage(), e);
        }
    }

    private List<NewsComment> makeRequestOnCommentNewsApiToSearchComments(String title) throws IOException, InterruptedException {
        String getCommentsUrl = this.applicationPropertiesReader
                .getPropertyByName(COMMENTS_API_KEY)+GET_COMMENTS_PATH+title.replaceAll(" ","%20");
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(getCommentsUrl))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        NewsComment[] newsCommentsListObj = gson.fromJson(response.body(), NewsComment[].class);
        return Arrays.asList(newsCommentsListObj);
    }

}
