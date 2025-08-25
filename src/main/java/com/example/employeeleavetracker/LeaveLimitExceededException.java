package com.example.employeeleavetracker;

// When employee tries to take more leaves than available
public class LeaveLimitExceededException extends RuntimeException {
    public LeaveLimitExceededException(String message) {
        super(message);
    }
}

