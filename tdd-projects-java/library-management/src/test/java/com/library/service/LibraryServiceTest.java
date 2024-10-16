package com.library.service;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

import com.library.model.Book;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.UserRepository;
import com.library.observer.BookAdditionObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryServiceTest {

    private LibraryService libraryService;
    private BookRepository bookRepository;
    private UserRepository userRepository;
    private BookAdditionObserver observer;

    @BeforeEach
    void setUp() {
        bookRepository = mock(BookRepository.class);
        userRepository = mock(UserRepository.class);
        observer = mock(BookAdditionObserver.class);
        libraryService = new LibraryService(bookRepository, userRepository);
        libraryService.addObserver(observer);
    }

    @Test
    void testAddBook() {
        Book book = new Book("Effective Java", "Hafedh Boukthir", "123456", "1");
        libraryService.addBook(book);

        verify(bookRepository, times(1)).save(book);
        verify(observer, times(1)).update(book);
    }

    @Test
    void testBorrowBook() {
        Book book = new Book("Effective Java", "Hafedh Boukthir", "123456", "125");
        User user = new User("100", "John Doe");

        when(bookRepository.findById("125")).thenReturn(book);
        when(userRepository.findById("100")).thenReturn(user);

        libraryService.borrowBook("125", "100");

        verify(bookRepository, times(1)).save(book);
        assert !book.isAvailable();
        assert book.getBorrower().equals(user);
    }

    @Test
    void testReturnBook() {
        Book book = new Book("Effective Java", "Hafedh Boukthir", "123456", "125");
        User user = new User("100", "John Doe");

        when(bookRepository.findById("125")).thenReturn(book);
        when(userRepository.findById("100")).thenReturn(user);

        libraryService.returnBook("125", "100");

        //verify(bookRepository, times(1)).save(book);
        assert book.isAvailable();
        assertNull (book.getBorrower());
    }
}
