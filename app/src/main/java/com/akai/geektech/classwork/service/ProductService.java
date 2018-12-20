package com.akai.geektech.classwork.service;

import com.akai.geektech.classwork.data.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    Product getProduct(long id);

    List<Product> getProducts();
}
