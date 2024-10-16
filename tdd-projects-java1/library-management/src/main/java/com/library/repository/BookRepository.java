package com.library.repository;

import java.util.List;

import com.library.model.Book;

public interface BookRepository {
    boolean save(Book book);

    Book findById(String id);

    List<Book> findAll();

    boolean deleteById(String id);
}
