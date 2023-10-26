package com.colutti.commentsapi.utils;

import com.colutti.commentsapi.domain.NewsComment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateNewsCommentDatabase {

    public static List<NewsComment> generateRandomComments() {
        List<NewsComment> commentsList = new ArrayList<>();
        String[] authors = {"Commenter 1", "Commenter 2", "Commenter 3", "Commenter 4", "Commenter 5"};
        String[] comments = {"Great article!", "I found this very interesting.", "Not sure about this.", "Well written.", "Thanks for sharing."};
        String[] titles = {"News 1", "News 2", "News 3", "News 4", "News 5", "News 6", "News 7", "News 8", "News 9", "News 10"};
        Random random = new Random();
        for (String newsTitle : titles) {
            int numComments = random.nextInt(5) + 1; // Generate 1 to 5 comments for each news
            for (int i = 0; i < numComments; i++) {
                String author = authors[random.nextInt(authors.length)];
                String comment = comments[random.nextInt(comments.length)];
                NewsComment newsComment = new NewsComment(author, comment, newsTitle);
                commentsList.add(newsComment);
            }
        }
        return commentsList;
    }
}

