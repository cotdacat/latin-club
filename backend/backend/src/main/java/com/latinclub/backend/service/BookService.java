package com.latinclub.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.latinclub.backend.model.Book;
import com.latinclub.backend.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> search(String search, String category) {
        // Convert empty strings to null so the JPQL IS NULL checks fire correctly
        String s = (search == null || search.isBlank()) ? null : search;
        String c = (category == null || category.isBlank()) ? null : category;
        return repository.search(s, c);
    }
}