package com.example.kuehne.service;

import com.example.kuehne.entity.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);

    List<Product> fetchProductList();

    Product fetchProductById(Long id);

    void deleteProductById(Long id);

    Product updateProduct(Long id, Product product);
}
