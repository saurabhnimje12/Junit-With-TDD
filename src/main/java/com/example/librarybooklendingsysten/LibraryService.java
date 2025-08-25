package com.example.librarybooklendingsysten;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    private List<Book> books;

    public LibraryService(List<Book> books) {
        this.books = books;
    }

    // Borrow a book if available and under user limit
    public void borrowBook(User user, String title) {
        if (user.getBorrowedBooks().size() >= 3) {
            throw new BookLimitExceededException("User has already borrowed 3 books.");
        }

        Optional<Book> bookOpt = books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title) && !b.isBorrowed())
                .findFirst();

        Book book = bookOpt.orElseThrow(() -> new BookUnavailableException("Book is not available."));

        book.borrow();
        user.borrowBook(book);
    }

    // Return a book by title
    public void returnBook(User user, String title) {
        Optional<Book> bookOpt = user.getBorrowedBooks().stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .findFirst();

        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.returned();
            user.returnBook(book);
        } else {
            throw new BookUnavailableException("User did not borrow this book.");
        }
    }

    // List all available books
    public List<Book> listAvailableBooks() {
        return books.stream()
                .filter(b -> !b.isBorrowed())
                .collect(Collectors.toList());
    }

    // List all borrowed books
    public List<Book> listBorrowedBooks() {
        return books.stream()
                .filter(Book::isBorrowed)
                .collect(Collectors.toList());
    }

    // Filter books by author
    public List<Book> filterBooksByAuthor(String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Filter books by genre
    public List<Book> filterBooksByGenre(String genre) {
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }
}
