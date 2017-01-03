package com.mas.services;

import com.mas.domain.model.Publisher;
import com.mas.domain.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    public List<Publisher> get() {
        return publisherRepository.findAll();
    }

    public Publisher get(int id) {
        return publisherRepository.findOne(id);
    }

    public Publisher create(Publisher publisher) {
        publisher.setId(0);
        return publisherRepository.save(publisher);
    }

    public Publisher update(int id, Publisher updatedPublisher) {
        Publisher publisher = publisherRepository.findOne(id);
        publisher.fillUpdateData(updatedPublisher);
        return publisherRepository.save(publisher);
    }
}
