package com.jorki.newsmanager.service;

import com.jorki.newsmanager.model.Category;
import com.jorki.newsmanager.model.News;

import java.util.List;

public interface CategoryService {

    public List<Category> listCategories();

    public void addCategory(String category);

    public void updateCategory(Integer id, String category);

    public void removeCategory(int id);

    public List<News> searchByCategory(Integer id);
}
