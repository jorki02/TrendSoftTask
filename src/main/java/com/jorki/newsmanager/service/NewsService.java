package com.jorki.newsmanager.service;

import com.jorki.newsmanager.controller.temp_entity.NewsCategory;
import com.jorki.newsmanager.model.News;

import java.util.List;

public interface NewsService {

    public void addNews(NewsCategory newsCategory);

    public void updateNews(NewsCategory newsCategory);

    public void removeNews(int id);

    public List<News> listNews();

    public List<News> searchByName(String name);
    public List<News> searchByContent(String content);

}
