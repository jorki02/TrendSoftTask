package com.jorki.newsmanager.dao;

import com.jorki.newsmanager.controller.temp_entity.NewsCategory;
import com.jorki.newsmanager.model.Category;
import com.jorki.newsmanager.model.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDaoImpl implements NewsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addNews(NewsCategory newsCategory) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            Category category = (Category) session.load(Category.class, newsCategory.getCategoryID());

            News news = new News();
            news.setName(newsCategory.getName());
            news.setDate(newsCategory.getDate());
            news.setContent(newsCategory.getContent());
            news.setName(newsCategory.getName());
            news.setCategory(category);
            session.save(news);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateNews(NewsCategory newsCategory) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            Category category = (Category) session.load(Category.class, newsCategory.getCategoryID());
            News news = (News) session.load(News.class, newsCategory.getId());

            news.setName(newsCategory.getName());
            news.setDate(newsCategory.getDate());
            news.setContent(newsCategory.getContent());
            news.setName(newsCategory.getName());
            news.setCategory(category);
            session.update(news);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void removeNews(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            News news = (News) session.load(News.class, id);
            session.delete(news);

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<News> listNews() {
        Session session = this.sessionFactory.openSession();
        List<News> newsList = session.createQuery("from News").list();
        session.close();

        return newsList;
    }

    @Override
    public List<News> searchByName(String name) {
        Session session = null;
        Transaction transaction = null;
        List<News> newsList = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from News where name = :name");
            query.setParameter("name", name);
            newsList = query.list();

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return newsList;
    }

    @Override
    public List<News> searchByContent(String content) {
        Session session = null;
        Transaction transaction = null;
        List<News> newsList = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            Query query = session.createQuery("from News where content = :content");
            query.setParameter("content", content);
            newsList = query.list();

            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return newsList;
    }
}
