package com.example.inventorymanagementsystem;

// Custom exception for invalid product data
public class InvalidProductException extends RuntimeException {
    public InvalidProductException(String message) {
        super(message);
    }
}