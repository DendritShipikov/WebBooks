package com.toto.books.dto;

import java.util.List;

public class BookDTO {

    private int id;

    private String title;

    private List<AuthorDTO> authors;

    private int pages;

    public BookDTO() {}

    public BookDTO(int id, String title, List<AuthorDTO> authors, int pages) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.pages = pages;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public List<AuthorDTO> getAuthors() { return authors; }

    public void setAuthors(List<AuthorDTO> authors) { this.authors = authors; }

    public int getPages() { return pages; }

    public void setPages(int pages) { this.pages = pages; }

}