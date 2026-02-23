package org.example;

import org.example.exception.EmptySaleException;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> products;
    private double totalPrice;

    public Sale() {};

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double calculateTotal() throws EmptySaleException {
        totalPrice = 0;
        if (!products.isEmpty()) {
            for (Product product : products) {
                totalPrice += product.getPrice();
            }
        } else {
            throw new EmptySaleException("Per fer una venda primer has d’afegir productes");
        }
        return totalPrice;
    }
 }
