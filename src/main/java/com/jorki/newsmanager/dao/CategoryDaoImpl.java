package com.jorki.newsmanager.dao;

import com.jorki.newsmanager.model.Category;
import com.jorki.newsmanager.model.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Category addCategory(String name) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            Category category = new Category();
            category.setName(name);
            session.save(category);

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
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Category> listCategories() {
        List<Category> newsList = null;
        Session session = null;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            newsList = session.createQuery("from Category").list();

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
    public void updateCategory(Integer id, String nameCategory) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            Category category = (Category) session.load(Category.class, id);
            category.setName(nameCategory);

            session.update(category);

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
    public void removeCategory(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            Category category = (Category) session.load(Category.class, id);
            session.delete(category);

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
    public List<News> searchByCategory(Integer id) {
        Session session = null;
        Transaction transaction = null;
        List<News> newsList = null;
        try {
            session = this.sessionFactory.openSession();
            transaction = session.beginTransaction();

            Category category = (Category) session.get(Category.class, id);


            newsList = new ArrayList<News>(category.getNews());

            /*for(News news : lazyNewsList){

            }*/

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
