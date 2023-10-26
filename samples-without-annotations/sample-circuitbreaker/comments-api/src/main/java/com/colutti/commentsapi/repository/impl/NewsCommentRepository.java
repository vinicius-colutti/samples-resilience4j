package com.colutti.commentsapi.repository.impl;

import com.colutti.commentsapi.domain.NewsComment;
import com.colutti.commentsapi.repository.INewsCommentRepository;
import com.colutti.commentsapi.utils.CreateNewsCommentDatabase;
import java.util.List;
import java.util.stream.Collectors;

public class NewsCommentRepository implements INewsCommentRepository {

    private List<NewsComment> newsCommentList;

    public NewsCommentRepository(){
        this.newsCommentList = CreateNewsCommentDatabase.generateRandomComments();
    }

    @Override
    public void save(NewsComment newsComment) {
        this.newsCommentList.add(newsComment);
    }

    @Override
    public List<NewsComment> getCommentsByNews(String newsTitle) {
        return this.newsCommentList.stream().filter(comments -> comments.getNewsTitle()
                .equals(newsTitle)).collect(Collectors.toList());
    }
}
