package com.jorki.newsmanager.service;

import com.jorki.newsmanager.dao.CategoryDao;
import com.jorki.newsmanager.model.Category;
import com.jorki.newsmanager.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> listCategories() {
        return categoryDao.listCategories();
    }

    @Override
    public void addCategory(String category) {
        categoryDao.addCategory(category);
    }

    @Override
    public void updateCategory(Integer id, String category) {
        categoryDao.updateCategory(id, category);
    }

    @Override
    public void removeCategory(int id) {
        categoryDao.removeCategory(id);
    }

    @Override
    public List<News> searchByCategory(Integer id) {
        return categoryDao.searchByCategory(id);
    }

}
