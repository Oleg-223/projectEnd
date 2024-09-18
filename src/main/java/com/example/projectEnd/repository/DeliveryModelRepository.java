package com.example.projectEnd.repository;

import com.example.projectEnd.model.DeliveryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryModelRepository extends JpaRepository<DeliveryModel,Long> {
}
