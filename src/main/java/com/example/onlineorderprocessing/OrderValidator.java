package com.example.onlineorderprocessing;

import java.util.function.Predicate;

public class OrderValidator {

    // Predicate to check if payment method is valid
    public static final Predicate<Order> isValidPayment = order ->
            order.getPaymentMethod() != null && !order.getPaymentMethod().isEmpty();

    // Predicate to check if delivery address is valid
    public static final Predicate<Order> isValidAddress = order ->
            order.getDeliveryAddress() != null && !order.getDeliveryAddress().trim().isEmpty();

    // Method to validate order and throw exceptions if needed
    public void validate(Order order) {
        if (!isValidPayment.test(order)) {
            throw new InvalidPaymentException("Payment method is invalid or missing.");
        }
        if (!isValidAddress.test(order)) {
            throw new InvalidAddressException("Delivery address is invalid or incomplete.");
        }
    }
}

