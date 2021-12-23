package com.toto.books.controllers;

import com.toto.books.services.*;
import com.toto.books.dto.*;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Controller
public class BookController {

    private BookService bookService;

    private AuthorService authorService;
    
    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }
    
    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String booksPage(Model model) {
        List<BookDTO> bookDtos = bookService.getAll();
        model.addAttribute("books", bookDtos);
        return "books";
    }

    @RequestMapping(value = "/viewbook", method = RequestMethod.GET)
    public String viewBookPage(@RequestParam int id, Model model) {
        BookDTO bookDto = bookService.getById(id);
        model.addAttribute("book", bookDto);
        return "viewbook";
    }

    @RequestMapping(value = "/addbook", method = RequestMethod.GET)
    public String addBookPage(Model model) {
        List<AuthorDTO> authorDtos = authorService.getAll();
        model.addAttribute("authors", authorDtos);
        return "addbook";
    }
    
    @RequestMapping(value = "/addbook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") BookDTO bookDto, @RequestParam int[] authorids) {
        List<AuthorDTO> authorDtos = new ArrayList<>();
        for (int id : authorids) {
            AuthorDTO authorDto = authorService.getById(id);
            authorDtos.add(authorDto);
        }
        bookDto.setAuthors(authorDtos);
        bookService.save(bookDto);
        return "redirect:/books";
    }

    @RequestMapping(value = "/editbook", method = RequestMethod.GET)
    public String editBookPage(@RequestParam int id, Model model) {
        BookDTO bookDto = bookService.getById(id);
        model.addAttribute("book", bookDto);
        List<AuthorDTO> authorDtos = authorService.getAll();
        model.addAttribute("authors", authorDtos);
        return "editbook";
    }

    @RequestMapping(value = "/editbook", method = RequestMethod.POST)
    public String editPage(@ModelAttribute("book") BookDTO bookDto, @RequestParam int[] authorids) {
        List<AuthorDTO> authorDtos = new ArrayList<>();
        for (int id : authorids) {
            AuthorDTO authorDto = authorService.getById(id);
            authorDtos.add(authorDto);
        }
        bookDto.setAuthors(authorDtos);
        bookService.save(bookDto);
        return "redirect:/books";
    }

    @RequestMapping("/deletebook")
    public String deleteBook(@RequestParam int id) {
        BookDTO bookDto = bookService.getById(id);
        bookService.delete(bookDto);
        return "redirect:/books";
    }

}