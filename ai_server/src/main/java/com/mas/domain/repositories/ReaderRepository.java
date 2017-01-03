package com.mas.domain.repositories;

import com.mas.domain.model.Users.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Integer> {
}
