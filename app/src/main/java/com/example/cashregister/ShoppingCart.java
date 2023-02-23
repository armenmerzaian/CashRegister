package com.example.cashregister;

import java.util.ArrayList;

public class ShoppingCart {

    //singleton
    static ShoppingCart shoppingCart;

    private static final ArrayList<Product> products = new ArrayList<>();
    private static int numProducts;
    private static double total;

    private ShoppingCart() {
        numProducts = 0;
        total = 0.0;
    }

    public static ShoppingCart getInstance() {
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
        }
        return shoppingCart;
    }

    public void addProduct(Product product) {
        products.set(numProducts, product);
        numProducts++;
        total += product.getPrice();
    }

    public double getTotal() {
        return total;
    }

    public int getNumProducts() {
        return products.size();
    }

    public void removeProduct(int index) {
        products.remove(index);
        numProducts--;
    }

    public void clear() {
        products.clear();
        total = 0.0;
        numProducts = 0;
    }
}
