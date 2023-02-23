package com.example.cashregister;

import androidx.room.Entity;

public class Product {
    private String _name;
    private double _price;
    private int _quantity;
    private CategoriesEnum _category;

    public Product(String name, double price, int quantity, CategoriesEnum category) {
        this._name = name;
        this._price = price;
        this._quantity = quantity;
        this._category = category;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public double getPrice() {
        return _price;
    }

    public void setPrice(double price) {
        this._price = price;
    }

    public int getQuantity() {
        return _quantity;
    }

    public void setQuantity(int quantity) {
        this._quantity = quantity;
    }

    public CategoriesEnum getCategory() {
        return _category;
    }

    public void setCategory(CategoriesEnum category) {
        this._category = category;
    }

}
