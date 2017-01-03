package com.mas.services;

import com.mas.domain.model.Character;
import com.mas.domain.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public List<Character> get(){
        return characterRepository.findAll();
    }

    public Character create(Character character) {
        character.setId(null);
        return characterRepository.save(character);
    }
}
