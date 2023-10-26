package com.colutti.newsapi.service;

import com.colutti.newsapi.dto.NewsComment;

import java.util.List;

public interface IFindNewsCommentsRequestService {

    List<NewsComment> getCommentsByNewsTitle(String title) throws Exception;

}
