package com.example.onlineorderprocessing;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order order = new Order(
                "Alice",
                Arrays.asList("Laptop", "Mouse"),
                "Credit Card",
                "123 Main Street, NY",
                null  // promo code is optional
        );

        OrderValidator validator = new OrderValidator();
        try {
            validator.validate(order);
            System.out.println("Order is valid. Promo: " + order.getPromoCode().orElse("No promo applied"));
        } catch (RuntimeException e) {
            System.out.println("Validation failed: " + e.getMessage());
        }
    }
}

