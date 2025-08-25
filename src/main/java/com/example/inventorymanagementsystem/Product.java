package com.example.inventorymanagementsystem;

public class Product {
    private String name;
    private String category;
    private double price;
    private int quantity;

    // Constructor to initialize product details
    public Product(String name, String category, double price, int quantity) {
        if (price < 0 || quantity < 0) {
            throw new InvalidProductException("Price and quantity must be non-negative.");
        }
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters for product fields
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price + ", Qty: " + quantity;
    }
}
