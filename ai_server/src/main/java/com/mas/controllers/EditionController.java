package com.mas.controllers;

import com.mas.domain.model.Edition;
import com.mas.services.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EditionController {
    @Autowired
    private EditionService editionService;

    @RequestMapping(value = "/api/books/{id}/editions", method = RequestMethod.GET)
    public List<Edition> get(@PathVariable int id) {
        return editionService.get(id);
    }
}
