package com.mas.services;

import com.mas.domain.repositories.BookReadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReadService {

    @Autowired
    BookReadRepository bookReadRepository;
}
