package com.mas.services;

import com.mas.domain.model.Genre;
import com.mas.domain.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    GenreRepository genreRepository;

    public List<Genre> get() {
        return genreRepository.findAll();
    }

    public Genre create(Genre genre) {
        genre.setId(null);
        return genreRepository.save(genre);
    }
}
