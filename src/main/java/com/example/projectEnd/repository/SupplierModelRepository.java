package com.example.projectEnd.repository;

import com.example.projectEnd.model.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierModelRepository extends JpaRepository<SupplierModel,Long> {
}
