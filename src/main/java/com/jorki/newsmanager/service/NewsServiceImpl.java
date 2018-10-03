package com.jorki.newsmanager.service;

import com.jorki.newsmanager.dao.NewsDao;
import com.jorki.newsmanager.controller.temp_entity.NewsCategory;
import com.jorki.newsmanager.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public void addNews(NewsCategory newsCategory) {
        newsDao.addNews(newsCategory);
    }

    @Override
    public void updateNews(NewsCategory newsCategory) {
        newsDao.updateNews(newsCategory);
    }

    @Override
    public void removeNews(int id) {
        newsDao.removeNews(id);
    }

    @Override
    public List<News> listNews() {
        return newsDao.listNews();
    }

    @Override
    public List<News> searchByName(String name) {
        return newsDao.searchByName(name);
    }

    @Override
    public List<News> searchByContent(String content) {
        return newsDao.searchByContent(content);
    }
}
