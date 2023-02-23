package com.example.cashregister;

import java.util.ArrayList;

public class Category {
    private CategoriesEnum _name;
    // Add any other category properties as needed
    private ArrayList<Product> _products;

    public Category(CategoriesEnum name) {
        this._name = name;
    }

    public CategoriesEnum getName() {
        return _name;
    }

    public ArrayList<Product> getProducts() {
        return _products;
    }

    public void setProducts(ArrayList<Product> products) {
        this._products = products;
    }

    // Add any other category getters and setters as needed
}

