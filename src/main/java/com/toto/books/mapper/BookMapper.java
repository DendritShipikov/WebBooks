package com.toto.books.mapper;

import com.toto.books.entities.Book;
import com.toto.books.dto.BookDTO;
import com.toto.books.entities.Author;
import com.toto.books.dto.AuthorDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;

@Component
public class BookMapper implements Mapper<Book, BookDTO> {

    private Mapper<Author, AuthorDTO> authorMapper;
    
    @Autowired
    public void setAuthorMapper(Mapper<Author, AuthorDTO> authorMapper) { this.authorMapper = authorMapper; }

    @Override
    public BookDTO toDTO(Book book) {
        List<AuthorDTO> authorDtos = new ArrayList<>();
        for (Author author : book.getAuthors()) {
            AuthorDTO authorDto = authorMapper.toDTO(author);
            authorDtos.add(authorDto);
        }
        return new BookDTO(book.getId(), book.getTitle(), authorDtos, book.getPages());
    }
    
    @Override
    public Book toEntity(BookDTO bookDto) {
        List<Author> authors = new ArrayList<>();
        for (AuthorDTO authorDto : bookDto.getAuthors()) {
            Author author = authorMapper.toEntity(authorDto);
            authors.add(author);
        }
        return new Book(bookDto.getId(), bookDto.getTitle(), authors, bookDto.getPages());
    }

}