package com.colutti.commentsapi.service;

import com.colutti.commentsapi.domain.NewsComment;

import java.util.List;

public interface IFindCommentService {
    List<NewsComment> getCommentsByNewsTitle(String newsTitle);
}
