package com.example.inventorymanagementsystem;

import java.util.*;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    // Adds a new product to the inventory
    public void addProduct(Product product) {
        products.add(product);
    }

    // Removes a product by name; throws exception if not found
    public void removeProduct(String name) {
        boolean removed = products.removeIf(p -> p.getName().equalsIgnoreCase(name));
        if (!removed) {
            throw new ProductNotFoundException("Product with name '" + name + "' not found.");
        }
    }

    // Filters products that have quantity less than 5
    public List<Product> filterLowStock() {
        return products.stream()
                .filter(p -> p.getQuantity() < 5)
                .collect(Collectors.toList());
    }

    // Sorts products by category and then by price
    public List<Product> sortByCategoryAndPrice() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getCategory)
                        .thenComparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    // Searches for a product by name; throws exception if not found
    public Product searchByName(String name) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not found: " + name));
    }

    // Searches for products by category; throws exception if none found
    public List<Product> searchByCategory(String category) {
        List<Product> found = products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        if (found.isEmpty()) {
            throw new ProductNotFoundException("No products found in category: " + category);
        }
        return found;
    }

    // Returns all products in the inventory
    public List<Product> getAllProducts() {
        return products;
    }
}
