package com.toto.books.services;

import com.toto.books.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO getById(int id);

    void save(BookDTO bookDto);

    List<BookDTO> getAll();
    
    List<BookDTO> search(String string);

    void delete(BookDTO bookDto);
}