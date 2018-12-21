package com.akai.geektech.classwork.service;

import com.akai.geektech.classwork.data.model.ProductEntity;

import java.util.List;

public interface ProductService {

    void addProduct(ProductEntity entity);

    ProductEntity getProduct(long id);

    List<ProductEntity> getProducts();
}
