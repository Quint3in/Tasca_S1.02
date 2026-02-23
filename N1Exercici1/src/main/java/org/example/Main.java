package org.example;

import org.example.exception.EmptySaleException;

public class Main {
    static void main() {
        Product product1 = new Product("product1",2.5);
        Product product2 = new Product("product2",10);

        Sale sale1 = new Sale();

        sale1.addProduct(product1);
        sale1.addProduct(product2);

        try {
            System.out.println(sale1.calculateTotal());
        } catch (EmptySaleException e) {
            throw new RuntimeException(e);
        }

        Sale sale2 = new Sale();

        try {
            System.out.println(sale2.calculateTotal());
        } catch (EmptySaleException e) {
            System.out.println(e.getMessage());
        }

        Product lastProduct = sale1.getLastProduct();
        System.out.println(lastProduct);

    }
}
