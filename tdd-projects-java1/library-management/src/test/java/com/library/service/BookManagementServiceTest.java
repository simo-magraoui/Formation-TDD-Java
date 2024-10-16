package com.library.service;

import com.library.model.Book;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagementServiceTest {
    private BookManagementService bookManagementService;

    @BeforeEach
    void setUp() {
        bookManagementService = BookManagementService.getInstance();
    }

    @Test
    void testAddBook() {
        Book book = new Book("Effective Java", "Hafedh Boukthir", "123456", "1");
        bookManagementService.addBook(book);
        assertEquals(1, bookManagementService.getBooks().size());
    }

    @Test
    void testFindBookByISBN() {
        Book book = new Book("Effective Java", "Hafedh Boukthir", "123456", "1");
        bookManagementService.addBook(book);
        Book foundBook = bookManagementService.findBookByISBN("123456");
        assertNotNull(foundBook);
        assertEquals("Effective Java", foundBook.getTitle());
    }
}
