package com.spring.service;

import com.spring.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product getProduct(int id);

    void addProduct(int id, String name, double price);

    boolean deleteProduct(int id);
}
