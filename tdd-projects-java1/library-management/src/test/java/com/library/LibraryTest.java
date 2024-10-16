package com.library;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class LibraryTest {
    @Test
    public void testCheckOutBook() {
        Library library = new Library();
        library.addBook(new Book("Effective Java"));
        assertTrue(library.checkOutBook("Effective Java"));
        assertFalse(library.checkOutBook("Effective Java"));
    }
}
class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean checkOutBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }
}

