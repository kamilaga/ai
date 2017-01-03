package com.mas.services;

import com.mas.domain.model.Author;
import com.mas.domain.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> get() {
        return authorRepository.findAll();
    }

    public Author get(int id){
        return authorRepository.findOne(id);
    }

    public Author create(Author author){
        author.setId(null);
        return authorRepository.save(author);
    }

    public Author update(int id, Author updatedAuthor){
        Author author = authorRepository.findOne(id);
        author.fillUpdateData(updatedAuthor);
        return authorRepository.save(author);
    }

}
