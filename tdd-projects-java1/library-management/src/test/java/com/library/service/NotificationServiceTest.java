package com.library.service;

import com.library.model.Book;
import com.library.observer.Library;
import org.mockito.Mockito;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotificationServiceTest {
    private Library library;
    private NotificationService notificationService;

    @BeforeEach
    public void setUp() {
        library = new Library();
        notificationService = Mockito.mock(NotificationService.class);
        library.addObserver(notificationService);
    }

    @Test
    void testNotifyObservers() {
        Book book = new Book("Effective Java", "Hafedh Boukthir", "123456", "1");
        library.addBook(book);
        Mockito.verify(notificationService, Mockito.times(1)).update(book);
    }
}
