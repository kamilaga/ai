package com.mas.controllers;

import com.mas.domain.model.Book;
import com.mas.domain.model.Genre;
import com.mas.domain.model.Publisher;
import com.mas.services.GenreService;
import com.mas.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @RequestMapping(value = "/api/publishers", method = RequestMethod.GET)
    public List<Publisher> get(){
        return publisherService.get();
    }

    @RequestMapping(value = "/api/publishers/{id}", method = RequestMethod.GET)
    public Publisher get(@PathVariable int id) {
        return publisherService.get(id);
    }

    @RequestMapping(value = "/api/publishers", method = RequestMethod.POST)
    public Publisher create(@RequestBody Publisher publisher){
        return publisherService.create(publisher);
    }

    @RequestMapping(value = "/api/publishers/{id}", method = RequestMethod.PUT)
    public Publisher update(@PathVariable int id, @RequestBody Publisher publisher) {
        return publisherService.update(id, publisher);
    }

}
