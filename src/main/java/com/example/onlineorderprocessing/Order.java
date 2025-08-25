package com.example.onlineorderprocessing;

import java.util.List;
import java.util.Optional;

public class Order {
    private String user;
    private List<String> items;
    private String paymentMethod;
    private String deliveryAddress;
    private Optional<String> promoCode;

    // Constructor to initialize order details
    public Order(String user, List<String> items, String paymentMethod, String deliveryAddress, String promoCode) {
        this.user = user;
        this.items = items;
        this.paymentMethod = paymentMethod;
        this.deliveryAddress = deliveryAddress;
        this.promoCode = Optional.ofNullable(promoCode); // Optional for nullable promo code
    }

    public String getUser() { return user; }
    public List<String> getItems() { return items; }
    public String getPaymentMethod() { return paymentMethod; }
    public String getDeliveryAddress() { return deliveryAddress; }
    public Optional<String> getPromoCode() { return promoCode; }
}
