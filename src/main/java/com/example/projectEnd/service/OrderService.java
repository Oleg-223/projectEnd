package com.example.projectEnd.service;

import com.example.projectEnd.model.OrderModel;

import java.util.List;

public interface OrderService {
    List<OrderModel> findAllOrder();
    OrderModel findOrderById(Long id);
    OrderModel createOrder(OrderModel order);
    OrderModel updateOrder(OrderModel order);
    void deleteOrder(Long id);
}
