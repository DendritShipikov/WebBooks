package com.toto.books.services;

import com.toto.books.dto.AuthorDTO;
import com.toto.books.dto.BookDTO;

import java.util.List;

public interface AuthorService {

    AuthorDTO getById(int id);

    void save(AuthorDTO authorDto);

    List<AuthorDTO> getAll();

    List<BookDTO> getBooks(AuthorDTO authorDto);

    void delete(AuthorDTO authorDto);

}