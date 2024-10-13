package com.crud.service;

import com.crud.model.Products;

import java.util.List;

public interface ProductServiceInterface {
    List<Products> getAllProducts();
    List<Products> getProductByName(String name);
    Products createNewProduct(Products products);
    Products updateExistingProduct(Products product);
}
