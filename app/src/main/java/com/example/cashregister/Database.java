package com.example.cashregister;

import java.util.ArrayList;

public class Database {

    //singleton
    private static Database _instance;
    private static ArrayList<Category> _categories;
    private static ArrayList<Product> _products;

    public static Database getInstance() {
        if (_instance == null) {
            _instance = new Database();
        }
        return _instance;
    }

    private Database() {
        _categories = new ArrayList<Category>();
        _products = new ArrayList<Product>();
        initDb();
    }

    private static void initDb(){
        _categories.add(new Category(CategoriesEnum.FOOD));
        _categories.add(new Category(CategoriesEnum.CLOTHING));
        _categories.add(new Category(CategoriesEnum.ELECTRONICS));
        _categories.add(new Category(CategoriesEnum.OTHER));

        _products.add(new Product("Apple", 1.00, 5, CategoriesEnum.FOOD));
        _products.add(new Product("Banana", 2.00, 10, CategoriesEnum.FOOD));
        _products.add(new Product("Orange", 3.00, 15, CategoriesEnum.FOOD));
        _products.add(new Product("Pineapple", 4.00, 20, CategoriesEnum.FOOD));

        _categories.get(0).setProducts(_products);
    }

    public static ArrayList<Category> getCategories() {
        return _categories;
    }

    public static ArrayList<Product> getProducts() {
        return _products;
    }
}
