package com.mas.domain.repositories;

import com.mas.domain.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByFirstNameAndLastName(String firstName, String lastName);

    List<Author> findByLastName(String lastName);
}
