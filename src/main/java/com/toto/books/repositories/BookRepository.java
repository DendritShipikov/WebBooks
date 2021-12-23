package com.toto.books.repositories;

import com.toto.books.entities.*;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;

import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookRepository {

    private SessionFactory sessionFactory;

    @Autowired
    public BookRepository(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
    
    @Transactional
    public Book getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Book book = session.get(Book.class, id);
        return book;
    }
    
    @Transactional
    public void save(Book book) {
        Session session = sessionFactory.getCurrentSession();
        if (book.getId() == 0) {
            session.save(book);
        } else {
            session.update(book);
        }
    }
    
    @Transactional
    public List<Book> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Book> books = session.createQuery("from Book order by title").getResultList();
        return books;
    }
    
    @Transactional
    public List<Book> search(String string) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Book where title like ?");
        query.setString(0, '%' + string + '%');
        List<Book> books = query.getResultList();
        return books;
    }
    
    @Transactional
    public void delete(Book book) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(book);
    }

}