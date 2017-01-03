package com.mas.domain.repositories;

import com.mas.domain.model.BookRead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReadRepository extends JpaRepository<BookRead, Integer> {
}
