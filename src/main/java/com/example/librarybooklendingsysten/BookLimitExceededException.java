package com.example.librarybooklendingsysten;

public class BookLimitExceededException extends RuntimeException {
    public BookLimitExceededException(String msg) {
        super(msg);
    }
}
