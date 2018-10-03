package com.jorki.newsmanager.dao;

import com.jorki.newsmanager.model.Category;
import com.jorki.newsmanager.model.News;

import java.util.List;

public interface CategoryDao {
    Category addCategory(String nameCategory);
    List<Category> listCategories();
    void updateCategory(Integer id, String nameCategory);
    void removeCategory(int id);
    List<News> searchByCategory(Integer id);
}
