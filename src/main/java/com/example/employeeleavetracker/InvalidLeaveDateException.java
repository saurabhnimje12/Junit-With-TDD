package com.example.employeeleavetracker;

// When an invalid leave date (e.g., past date) is applied
public class InvalidLeaveDateException extends RuntimeException {
    public InvalidLeaveDateException(String message) {
        super(message);
    }
}
