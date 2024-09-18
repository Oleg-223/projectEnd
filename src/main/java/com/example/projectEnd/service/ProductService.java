package com.example.projectEnd.service;

import com.example.projectEnd.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> findAllProduct();
    ProductModel findProductById(Long id);
    ProductModel createProduct(ProductModel order);
    ProductModel updateProduct(ProductModel order);
    void deleteProduct(Long id);
}
