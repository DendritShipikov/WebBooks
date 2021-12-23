package com.toto.books.dto;

import java.util.List;

public class AuthorDTO {

    private int id;

    private String name;

    public AuthorDTO() {}

    public AuthorDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }

    public void setId() { this.id = id; }
    
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}