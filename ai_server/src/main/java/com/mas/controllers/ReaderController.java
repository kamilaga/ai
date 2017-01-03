package com.mas.controllers;

import com.mas.domain.model.Users.Reader;
import com.mas.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/readers")
public class ReaderController {

    @Autowired
    private ReaderService clientService;

    @RequestMapping(method = RequestMethod.POST)
    public Reader create(@RequestBody Reader reader){
        return clientService.create(reader);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Reader> get(){
        return clientService.get();
    }

}
