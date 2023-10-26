package com.colutti.newsapi.controller;

import com.colutti.newsapi.domain.News;
import com.colutti.newsapi.service.IFindNewsService;
import com.colutti.newsapi.service.impl.FindNewsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    private IFindNewsService findNewsService;

    public NewsController(){
        this.findNewsService = new FindNewsService();
    }

    @GetMapping
    public List<News> findAllNews(){
        return this.findNewsService.getAllNews();
    }

    @GetMapping("/{title}")
    public News findNewsByTitlte(@PathVariable("title") String title) throws Exception {
        return this.findNewsService.getNewsByTitle(title);
    }

}
