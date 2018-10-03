package com.jorki.newsmanager.controller;

import com.jorki.newsmanager.controller.temp_entity.NewsCategory;
import com.jorki.newsmanager.model.News;
import com.jorki.newsmanager.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<News> listNews(){
        return this.newsService.listNews();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<News> addNews(@RequestBody NewsCategory newsCategory) {
        newsService.addNews(newsCategory);

        return this.newsService.listNews();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public List<News> updateNews(@RequestBody NewsCategory newsCategory) {
        newsService.updateNews(newsCategory);

        return this.newsService.listNews();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public List<News> removeNews(@RequestBody String id) {
        newsService.removeNews(Integer.parseInt(id));

        return this.newsService.listNews();
    }

    @RequestMapping(value = "/searchByName", method = RequestMethod.POST)
    public List<News> searchNewsByName(@RequestBody String name) {
        return newsService.searchByName(name);
    }

    @RequestMapping(value = "/searchByContent", method = RequestMethod.POST)
    public List<News> searchNewsByContent(@RequestBody String content) {
        return newsService.searchByContent(content);
    }

}
