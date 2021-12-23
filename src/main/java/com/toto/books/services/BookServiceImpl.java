package com.toto.books.services;

import com.toto.books.entities.Book;
import com.toto.books.dto.BookDTO;
import com.toto.books.repositories.BookRepository;
import com.toto.books.mapper.Mapper;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

import java.util.List;
import java.util.ArrayList;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    
    private Mapper<Book, BookDTO> bookMapper;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository, Mapper<Book, BookDTO> bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }
    
    @Override
    @Transactional
    public BookDTO getById(int id) {
        Book book = bookRepository.getById(id);
        return bookMapper.toDTO(book);
    }
    
    @Override
    @Transactional
    public void save(BookDTO bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        bookRepository.save(book);
    }
    
    @Override
    @Transactional
    public List<BookDTO> getAll() {
        List<Book> books = bookRepository.getAll();
        List<BookDTO> bookDtos = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDto = bookMapper.toDTO(book);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }
    
    @Override
    @Transactional
    public List<BookDTO> search(String string) {
        List<Book> books = bookRepository.search(string);
        List<BookDTO> bookDtos = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDto = bookMapper.toDTO(book);
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @Override
    @Transactional
    public void delete(BookDTO bookDto) {
        Book book = bookMapper.toEntity(bookDto);
        bookRepository.delete(book);
    }

}