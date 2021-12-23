package com.toto.books.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "title")
    private String title;
    
    @ManyToMany
    @JoinTable(
        name = "bookstoauthors",
        joinColumns = @JoinColumn(name = "bookid"),
        inverseJoinColumns = @JoinColumn(name = "authorid")
    )
    private List<Author> authors;

    @Column(name = "pages")
    private int pages;

    public Book() {}

    public Book(int id, String title, List<Author> authors, int pages) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.pages = pages;
    }

    public int getId() { return id; }
    
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }
    
    public List<Author> getAuthors() { return authors; }

    public void setAuthors(List<Author> authors) { this.authors = authors; }

    public int getPages() { return pages; }

    public void setPages(int pages) { this.pages = pages; }
    
}