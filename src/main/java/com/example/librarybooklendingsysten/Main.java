package com.example.librarybooklendingsysten;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "Orwell", "Dystopian");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee", "Classic");
        Book b3 = new Book("The Hobbit", "Tolkien", "Fantasy");
        List<Book> books = Arrays.asList(b1, b2, b3);

        LibraryService library = new LibraryService(books);
        User user = new User("Alice");

        library.borrowBook(user, "1984");
        library.borrowBook(user, "The Hobbit");

        System.out.println("Borrowed Books:");
        user.getBorrowedBooks().forEach(b -> System.out.println(b.getTitle()));

        library.returnBook(user, "1984");

        System.out.println("\nAvailable Books:");
        library.listAvailableBooks().forEach(b -> System.out.println(b.getTitle()));
    }
}
