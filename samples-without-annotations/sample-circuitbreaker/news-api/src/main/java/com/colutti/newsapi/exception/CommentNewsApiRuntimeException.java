package com.colutti.newsapi.exception;

public class CommentNewsApiRuntimeException extends RuntimeException {

    public CommentNewsApiRuntimeException() {
        super();
    }

    public CommentNewsApiRuntimeException(String message){
        super(message);
    }

}
