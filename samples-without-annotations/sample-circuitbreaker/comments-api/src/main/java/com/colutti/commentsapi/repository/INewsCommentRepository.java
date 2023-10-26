package com.colutti.commentsapi.repository;

import com.colutti.commentsapi.domain.NewsComment;

import java.util.List;

public interface INewsCommentRepository {
    void save(NewsComment newsComment);
    List<NewsComment> getCommentsByNews(String newsTitle);
}
