package com.jorki.newsmanager.controller.temp_entity;

import java.util.Date;

public class NewsCategory {

    private int id;
    private String name;
    private String content;
    private Date date;
    private int categoryID;

    public NewsCategory() {
    }

    public NewsCategory(int id, String name, String content, Date date, int categoryID) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.date = date;
        this.categoryID = categoryID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }
}
