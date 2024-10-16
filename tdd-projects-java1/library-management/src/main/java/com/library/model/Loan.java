package com.library.model;

import java.util.Date;
import java.util.UUID;

public class Loan {

    private String id;
    private Book book;
    private User user;
    private Date loanDate;
    private Date returnDate;

    public Loan(Book book, User user, Date loanDate, Date returnDate) {
        this.id = UUID.randomUUID().toString();
        this.book = book;
        this.user = user;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
