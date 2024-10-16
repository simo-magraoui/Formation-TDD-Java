package com.library.service;

import com.library.model.Book;
import com.library.model.User;
import com.library.observer.BookAdditionObserver;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private List<BookAdditionObserver> observers = new ArrayList<>();

    public LibraryService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public void addObserver(BookAdditionObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(BookAdditionObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Book book) {
        for (BookAdditionObserver observer : observers) {
            observer.update(book);
        }
    }

    public void addBook(Book book) {
        bookRepository.save(book);
        notifyObservers(book);
    }

    public void borrowBook(String bookId, String userId) {
        Book book = bookRepository.findById(bookId);
        User user = userRepository.findById(userId);
        if (book != null && user != null && book.isAvailable()) {
            book.setBorrower(user);
            book.setAvailable(false);
            bookRepository.save(book);
        }
    }
    //returnBook
    public void returnBook(String bookId, String userId) {
        Book book = bookRepository.findById(bookId);
        User user = userRepository.findById(userId);
        if (book != null && user != null && !book.isAvailable()) {
            book.setBorrower(null);
            book.setAvailable(true);
            bookRepository.save(book);
        }
    }
}
