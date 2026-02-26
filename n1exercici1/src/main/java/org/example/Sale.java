package org.example;

import org.example.exception.EmptySaleException;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> products;
    private double totalPrice;

    public Sale() {
        products = new ArrayList<>();
    };

    public void addProduct(Product product) {
        products.add(product);
    }

    //Test indexOutOfBoundsException
    public Product getLastProduct() {
        try{
            return products.get(100);
        } catch(IndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException("Producte fora de la llista.");
        }
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
