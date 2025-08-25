package com.example.librarybooklendingsysten;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Borrow a book and add to user record
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    // Return a book and remove from user record
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}

