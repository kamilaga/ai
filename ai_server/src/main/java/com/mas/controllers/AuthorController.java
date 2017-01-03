package com.mas.controllers;

import com.mas.domain.model.Author;
import com.mas.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/api/authors", method = RequestMethod.GET)
    public List<Author> get() {
        return authorService.get();
    }

    @RequestMapping(value = "/api/authors/{id}", method = RequestMethod.GET)
    public Author get(@PathVariable int id) {
        return authorService.get(id);
    }

    @RequestMapping(value = "/api/authors", method = RequestMethod.POST)
    public Author create(@RequestBody Author author) {
        return authorService.create(author);
    }

    @RequestMapping(value = "/api/authors/{id}", method = RequestMethod.PUT)
    public Author update(@PathVariable int id, @RequestBody Author author) {
        return authorService.update(id, author);
    }

}
