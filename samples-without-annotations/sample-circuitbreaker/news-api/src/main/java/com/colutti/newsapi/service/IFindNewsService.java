package com.colutti.newsapi.service;

import com.colutti.newsapi.domain.News;

import java.util.List;

public interface IFindNewsService {
    List<News> getAllNews();
    News getNewsByTitle(String title) throws Exception;
}
