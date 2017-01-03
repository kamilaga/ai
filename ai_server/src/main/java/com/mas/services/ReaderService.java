package com.mas.services;

import com.mas.domain.model.Users.Reader;
import com.mas.domain.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class ReaderService {
    @Autowired
    private ReaderRepository readerRepository;

    public Reader create(Reader newClient) {
        return readerRepository.saveAndFlush(parseNewClientData(newClient));
    }

    public List<Reader> get(){
        return readerRepository.findAll();
    }

    private Reader parseNewClientData(Reader reader) {
        return Reader.builder()
                .email(reader.getEmail())
                .registrationDate(LocalDateTime.now())
                .build();
    }
}
