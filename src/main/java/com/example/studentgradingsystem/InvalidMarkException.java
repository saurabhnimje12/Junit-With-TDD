package com.example.studentgradingsystem;

// Thrown when marks contain invalid values
public class InvalidMarkException extends RuntimeException {
    public InvalidMarkException(String msg) {
        super(msg);
    }
}
