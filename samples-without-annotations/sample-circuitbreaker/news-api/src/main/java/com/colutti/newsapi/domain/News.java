package com.colutti.newsapi.domain;

import com.colutti.newsapi.dto.NewsComment;
import java.util.List;

public class News {

    private String title;
    private String author;
    private String description;
    private Category category;
    private List<NewsComment> commentList;

    public News(){}

    public News(String title, String author, String description, Category category, List<NewsComment> commentList) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.category = category;
        this.commentList = commentList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<NewsComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<NewsComment> commentList) {
        this.commentList = commentList;
    }

}
