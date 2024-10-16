package com.library.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private String id;
    private boolean available;
    private User borrower;

    // Constructors, getters, and setters
    public Book(String title, String author, String isbn, String id) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.id = id;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }
}
