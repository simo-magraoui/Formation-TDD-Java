package com.library.observer;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<BookAdditionObserver> observers = new ArrayList<>();
    private List<Book> books = new ArrayList<>();

    public void addObserver(BookAdditionObserver observer) {
        observers.add(observer);
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers(book);
    }

    private void notifyObservers(Book book) {
        for (BookAdditionObserver observer : observers) {
            observer.update(book);
        }
    }
}
