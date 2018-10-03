package com.jorki.newsmanager.controller;

import com.jorki.newsmanager.model.Category;
import com.jorki.newsmanager.model.News;
import com.jorki.newsmanager.controller.temp_entity.CategoryNameId;
import com.jorki.newsmanager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Collection<Category> listCategories(){
        return this.categoryService.listCategories();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<Category> addCategory(@RequestBody String categoryName) {
        categoryService.addCategory(categoryName);

        return this.categoryService.listCategories();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<Category> updateCategory(@RequestBody CategoryNameId categoryNameId) {
        categoryService.updateCategory(categoryNameId.getId(), categoryNameId.getName());

        return this.categoryService.listCategories();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public List<Category> updateCategory(@RequestBody Integer id) {
        categoryService.removeCategory(id);

        return this.categoryService.listCategories();
    }

    @RequestMapping(value = "/searchByCategory", method = RequestMethod.POST)
    public List<News> searchNewsByContent(@RequestBody Integer id) {
        return categoryService.searchByCategory(id);
    }

}
