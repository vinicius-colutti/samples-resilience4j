package com.colutti.newsapi.util;

import com.colutti.newsapi.domain.Category;
import com.colutti.newsapi.domain.News;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CreateNewsDatabase {

    public static List<News> create(){
        List<News> newsList = new ArrayList<>();
        String[] titles = {"News 1", "News 2", "News 3", "News 4", "News 5", "News 6", "News 7", "News 8", "News 9", "News 10"};
        String[] authors = {"Author 1", "Author 2", "Author 3", "Author 4", "Author 5", "Author 6", "Author 7", "Author 8", "Author 9", "Author 10"};
        String[] descriptions = {"Description 1", "Description 2", "Description 3", "Description 4", "Description 5", "Description 6", "Description 7", "Description 8", "Description 9", "Description 10"};
        String[] categoryNames = {"Politics", "Technology", "Sports", "Entertainment", "Science", "Health"};
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            String title = titles[i];
            String author = authors[i];
            String description = descriptions[i];
            String categoryName = categoryNames[random.nextInt(categoryNames.length)];
            Category category = new Category(categoryName);
            News news = new News(title, author, description, category, Collections.emptyList());
            newsList.add(news);
        }
        return newsList;
    }

}
