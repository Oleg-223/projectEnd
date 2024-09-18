package com.example.projectEnd.service;

import com.example.projectEnd.model.ProductModel;
import com.example.projectEnd.repository.ProductModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductModelRepository productModelRepository;

    public ProductServiceImpl(ProductModelRepository productModelRepository) {
        this.productModelRepository = productModelRepository;
    }

    @Override
    public List<ProductModel> findAllProduct() {
        return productModelRepository.findAll();
    }

    @Override
    public ProductModel findProductById(Long id) {
        return productModelRepository.findById(id).get();
    }

    @Override
    public ProductModel createProduct(ProductModel product) {
        return productModelRepository.save(product);
    }

    @Override
    public ProductModel updateProduct(ProductModel product) {
        return productModelRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productModelRepository.deleteById(id);
    }
}
