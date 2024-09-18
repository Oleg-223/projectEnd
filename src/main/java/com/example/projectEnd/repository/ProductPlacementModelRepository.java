package com.example.projectEnd.repository;

import com.example.projectEnd.model.ProductPlacementModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPlacementModelRepository extends JpaRepository<ProductPlacementModel,Long> {
}
