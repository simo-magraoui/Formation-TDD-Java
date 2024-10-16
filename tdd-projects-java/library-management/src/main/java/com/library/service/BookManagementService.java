package com.library.service;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookManagementService {
    private List<Book> books = new ArrayList<>();

    // Singleton implementation
    private static final BookManagementService instance = new BookManagementService();

    private BookManagementService() {
    }

    public static BookManagementService getInstance() {
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
