package com.toto.books.mapper;

import com.toto.books.entities.Author;
import com.toto.books.dto.AuthorDTO;
import com.toto.books.entities.Book;
import com.toto.books.dto.BookDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class AuthorMapper implements Mapper<Author, AuthorDTO> {

    @Override
    public AuthorDTO toDTO(Author author) {
        return new AuthorDTO(author.getId(), author.getName());
    }

    @Override
    public Author toEntity(AuthorDTO authorDto) {
        return new Author(authorDto.getId(), authorDto.getName(), null);
    }

}