package com.colutti.commentsapi.domain;

public class NewsComment {

    private String author;
    private String comment;
    private String newsTitle;

    public NewsComment(){}

    public NewsComment(String author, String comment, String newsTitle) {
        this.author = author;
        this.comment = comment;
        this.newsTitle = newsTitle;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
