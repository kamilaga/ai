package com.mas.controllers;

import com.mas.domain.model.Book;
import com.mas.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/api/books", method = RequestMethod.GET)
    public List<Book> get(){
        return bookService.get();
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.GET)
    public Book get(@PathVariable int id) {
        return bookService.get(id);
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book create(@RequestBody Book book){
        return bookService.create(book);
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
    public Book update(@PathVariable int id, @RequestBody Book book) {
        return bookService.update(id, book);
    }
}
