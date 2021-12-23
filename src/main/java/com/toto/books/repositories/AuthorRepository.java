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
public class AuthorRepository {
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public AuthorRepository(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
    
    @Transactional
    public Author getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Author author = session.get(Author.class, id);
        return author;
    }
    
    @Transactional
    public void save(Author author) {
        Session session = sessionFactory.getCurrentSession();
        if (author.getId() == 0) {
            session.save(author);
        } else {
            session.update(author);
        }
    }
    
    @Transactional
    public List<Author> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Author> authors = session.createQuery("from Author order by name").getResultList();
        return authors;
    }
    
    @Transactional
    public void delete(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(author);
    }

}