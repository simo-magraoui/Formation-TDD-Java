package com.library.service;

import com.library.model.Book;
import com.library.observer.BookAdditionObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NotificationService implements BookAdditionObserver {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Override
    public void update(Book book) {
        logger.info("Notification: New book added - ");
    }
}
