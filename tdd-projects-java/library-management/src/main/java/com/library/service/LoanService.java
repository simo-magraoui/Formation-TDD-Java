package com.library.service;

import com.library.model.Book;
import com.library.model.Loan;
import com.library.model.User;
import com.library.repository.BookRepository;
import com.library.repository.LoanRepository;

import java.util.Date;

public class LoanService {

    private LoanRepository loanRepository;
    private BookRepository bookRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
    }

    public boolean loanBook(Book book, User user) {
        if (book.isAvailable()) {
            Loan loan = new Loan(book, user, new Date(), null);
            book.setAvailable(false);
            bookRepository.save(book);
            loanRepository.save(loan);
            return true;
        }
        return false;
    }
}
