package com.mas.services;

import com.mas.domain.model.Book;
import com.mas.domain.repositories.AuthorRepository;
import com.mas.domain.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> get() {
        return bookRepository.findAll();
    }

    public Book get(int id) {
        return bookRepository.findOne(id);
    }

    public Book create(Book book) {
        book.setId(null);
        book.getEditions().forEach(edition -> edition.setBook(book));
        return bookRepository.save(book);
    }

    public Book update(int id, Book updatedBook){
        Book book = bookRepository.findOne(id);
        book.fillUpdateData(updatedBook);
        return bookRepository.save(book);
    }
}