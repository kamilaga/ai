package com.mas.services;

import com.mas.domain.model.Book;
import com.mas.domain.model.Edition;
import com.mas.domain.repositories.EditionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionService {

    @Autowired
    EditionRepository editionRepository;

    public List<Edition> get(int id) {
        return editionRepository.findByBookId(id);
    }
}
