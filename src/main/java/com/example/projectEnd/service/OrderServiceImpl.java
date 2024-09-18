package com.example.projectEnd.service;

import com.example.projectEnd.model.OrderModel;
import com.example.projectEnd.repository.OrderModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderModelRepository orderModelRepository;

    public OrderServiceImpl(OrderModelRepository orderModelRepository) {
        this.orderModelRepository = orderModelRepository;
    }

    @Override
    public List<OrderModel> findAllOrder() {
        return orderModelRepository.findAll();
    }

    @Override
    public OrderModel findOrderById(Long id) {
        return orderModelRepository.findById(id).get();
    }

    @Override
    public OrderModel createOrder(OrderModel order) {
        return orderModelRepository.save(order);
    }

    @Override
    public OrderModel updateOrder(OrderModel order) {
        return orderModelRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderModelRepository.deleteById(id);
    }
}
