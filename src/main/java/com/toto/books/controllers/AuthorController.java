package com.toto.books.controllers;

import com.toto.books.services.AuthorService;
import com.toto.books.dto.AuthorDTO;
import com.toto.books.dto.BookDTO;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) { this.authorService = authorService; }
    
    @RequestMapping("/authors")
    public String authorsPage(Model model) {
        List<AuthorDTO> authorDtos = authorService.getAll();
        model.addAttribute("authors", authorDtos);
        return "authors";
    }

    @RequestMapping("/viewauthor")
    public String viewAuthorPage(@RequestParam int id, Model model) {
        AuthorDTO authorDto = authorService.getById(id);
        model.addAttribute("author", authorDto);
        List<BookDTO> bookDtos = authorService.getBooks(authorDto);
        model.addAttribute("books", bookDtos);
        return "viewauthor";
    }

    @RequestMapping(value = "/addauthor", method = RequestMethod.GET)
    public String addAuthorPage() {
        return "addauthor";
    }

    @RequestMapping(value = "/addauthor", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author") AuthorDTO authorDto) {
        authorService.save(authorDto);
        return "redirect:/authors";
    }

    @RequestMapping("/deleteauthor")
    public String deleteAuthor(@RequestParam int id) {
        AuthorDTO authorDto = authorService.getById(id);
        authorService.delete(authorDto);
        return "redirect:/authors";
    }
    
}