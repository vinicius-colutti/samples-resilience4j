package com.colutti.newsapi.service.impl;

import com.colutti.newsapi.domain.News;
import com.colutti.newsapi.repository.INewsRepository;
import com.colutti.newsapi.repository.impl.NewsRepository;
import com.colutti.newsapi.service.IFindNewsCommentsRequestService;
import com.colutti.newsapi.service.IFindNewsService;
import com.colutti.newsapi.util.ApplicationPropertiesReader;

import java.util.List;

public class FindNewsService implements IFindNewsService {

    private INewsRepository newsRepository;
    private IFindNewsCommentsRequestService findNewsCommentsRequestService;

    public FindNewsService(){
        this.newsRepository = new NewsRepository();
        this.findNewsCommentsRequestService = new FindNewsCommentsRequestService();
    }

    @Override
    public List<News> getAllNews(){
        return this.newsRepository.getAll();
    }

    @Override
    public News getNewsByTitle(String title) throws Exception {
        News news = this.newsRepository.getByTitle(title);
        news.setCommentList(findNewsCommentsRequestService.getCommentsByNewsTitle(
                news.getTitle()
        ));
        return news;
    }

}
