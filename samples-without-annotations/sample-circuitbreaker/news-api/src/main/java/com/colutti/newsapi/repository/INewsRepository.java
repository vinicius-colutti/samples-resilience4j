package com.colutti.newsapi.repository;

import com.colutti.newsapi.domain.News;

import java.util.List;

public interface INewsRepository {

    void save(News news);
    News getByTitle(String title);
    List<News> getAll();

}
