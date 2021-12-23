package com.toto.books.services;

import com.toto.books.entities.Author;
import com.toto.books.dto.AuthorDTO;
import com.toto.books.entities.Book;
import com.toto.books.dto.BookDTO;
import com.toto.books.repositories.AuthorRepository;
import com.toto.books.mapper.Mapper;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    
    private Mapper<Author, AuthorDTO> authorMapper;

    private Mapper<Book, BookDTO> bookMapper;
    
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, Mapper<Author, AuthorDTO> authorMapper, Mapper<Book, BookDTO> bookMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.bookMapper = bookMapper;
    }
    
    @Override
    @Transactional
    public AuthorDTO getById(int id) {
        Author author = authorRepository.getById(id);
        return authorMapper.toDTO(author);
    }
    
    @Override
    @Transactional
    public void save(AuthorDTO authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.save(author);
    }
    
    @Override
    @Transactional
    public List<AuthorDTO> getAll() {
        List<Author> authors = authorRepository.getAll();
        List<AuthorDTO> authorDtos = new ArrayList<>();
        for (Author author : authors) {
            AuthorDTO authorDto = authorMapper.toDTO(author);
            authorDtos.add(authorDto);
        }
        return authorDtos;
    }

    @Override
    @Transactional
    public List<BookDTO> getBooks(AuthorDTO authorDto) {
        Author author = authorRepository.getById(authorDto.getId());
        List<Book> books = author.getBooks();
        List<BookDTO> bookDtos = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDto = bookMapper.toDTO(book);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    @Transactional
    public void delete(AuthorDTO authorDto) {
        Author author = authorMapper.toEntity(authorDto);
        authorRepository.delete(author);
    }

}