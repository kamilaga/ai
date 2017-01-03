package com.mas.controllers;

import com.mas.domain.model.Character;
import com.mas.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Character> get(){
        return characterService.get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Character create(@RequestBody Character character){
        return characterService.create(character);
    }
}
