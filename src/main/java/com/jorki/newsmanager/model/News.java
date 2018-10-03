package com.jorki.newsmanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "NEWS")
public class News {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NEWS_NAME")
    private String name;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne
    @JoinColumn(name="category_id", nullable=false)
    private Category category;

    public News() {
    }

    public News(String name, String content, Date date, Category category) {
        this.name = name;
        this.content = content;
        this.date = date;
        this.category = category;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
