package com.example.projectEnd.repository;

import com.example.projectEnd.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderModelRepository extends JpaRepository<OrderModel,Long> {
}
