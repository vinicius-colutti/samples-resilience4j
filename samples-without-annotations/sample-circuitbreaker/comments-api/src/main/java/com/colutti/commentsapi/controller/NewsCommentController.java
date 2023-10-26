package com.colutti.commentsapi.controller;

import com.colutti.commentsapi.domain.NewsComment;
import com.colutti.commentsapi.service.IFindCommentService;
import com.colutti.commentsapi.service.impl.FindCommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/newscomments")
public class NewsCommentController {

    private IFindCommentService findCommentService;

    public NewsCommentController(){
        this.findCommentService = new FindCommentService();
    }

    @GetMapping("/{news_title}")
    public List<NewsComment> findNewsCommentsByNewsTitle(
            @PathVariable("news_title") String newsTitle){
        return this.findCommentService.getCommentsByNewsTitle(newsTitle);
    }

}
