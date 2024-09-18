package com.example.projectEnd.service;

import com.example.projectEnd.model.ProductPlacementModel;

import java.util.List;

public interface ProductPlacementService {
    List<ProductPlacementModel> findAllProductPlacement();
    ProductPlacementModel findProductPlacementById(Long id);
    ProductPlacementModel createProductPlacement(ProductPlacementModel productPlacement);
    ProductPlacementModel updateProductPlacement(ProductPlacementModel ProductPlacement);
    void deleteProductPlacement(Long id);
}
