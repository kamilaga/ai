package com.mas.domain.repositories;

import com.mas.domain.model.Author;
import com.mas.domain.model.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditionRepository extends JpaRepository<Edition, Integer> {

    List<Edition> findByBookId(Integer id);
}
