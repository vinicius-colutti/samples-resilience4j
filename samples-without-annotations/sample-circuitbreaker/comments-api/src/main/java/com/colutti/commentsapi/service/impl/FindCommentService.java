package com.colutti.commentsapi.service.impl;

import com.colutti.commentsapi.domain.NewsComment;
import com.colutti.commentsapi.repository.INewsCommentRepository;
import com.colutti.commentsapi.repository.impl.NewsCommentRepository;
import com.colutti.commentsapi.service.IFindCommentService;

import java.util.List;

public class FindCommentService implements IFindCommentService {

    private INewsCommentRepository newsCommentRepository;

    public FindCommentService(){
        this.newsCommentRepository = new NewsCommentRepository();
    }

    @Override
    public List<NewsComment> getCommentsByNewsTitle(String newsTitle) {
        return newsCommentRepository.getCommentsByNews(newsTitle);
    }
}
