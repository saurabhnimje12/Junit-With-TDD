package com.example.onlineorderprocessing;

// Thrown when payment method is invalid or missing
public class InvalidPaymentException extends RuntimeException {
    public InvalidPaymentException(String msg) {
        super(msg);
    }
}

