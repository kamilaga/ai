package com.mas.controllers;

import com.mas.domain.model.Genre;
import com.mas.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Genre> get(){
        return genreService.get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Genre create(@RequestBody Genre genre){
        return genreService.create(genre);
    }
}
