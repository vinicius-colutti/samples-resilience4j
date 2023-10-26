package com.colutti.newsapi.repository.impl;

import com.colutti.newsapi.domain.News;
import com.colutti.newsapi.repository.INewsRepository;
import com.colutti.newsapi.util.CreateNewsDatabase;
import java.util.List;
import java.util.stream.Collectors;

public class NewsRepository implements INewsRepository {

    private List<News> newsList;

    public NewsRepository(){
        this.newsList = CreateNewsDatabase.create();
    }

    @Override
    public void save(News news) {
        this.newsList.add(news);
    }

    @Override
    public News getByTitle(String title) {
        return this.newsList.stream().filter(news -> news.getTitle().equals(title)).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<News> getAll() {
        return this.newsList;
    }
}
