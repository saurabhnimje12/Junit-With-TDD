package com.example.studentgradingsystem;

// Thrown when a student has no marks
public class EmptyMarkListException extends RuntimeException {
    public EmptyMarkListException(String msg) {
        super(msg);
    }
}

