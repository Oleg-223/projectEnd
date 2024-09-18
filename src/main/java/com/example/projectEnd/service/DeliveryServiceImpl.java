package com.example.projectEnd.service;

import com.example.projectEnd.model.DeliveryModel;
import com.example.projectEnd.repository.DeliveryModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryModelRepository deliveryModelRepository;

    public DeliveryServiceImpl(DeliveryModelRepository deliveryModelRepository) {
        this.deliveryModelRepository = deliveryModelRepository;
    }

    @Override
    public List<DeliveryModel> findAllDelivery() {
        return deliveryModelRepository.findAll();
    }

    @Override
    public DeliveryModel findDeliveryById(Long id) {
        return deliveryModelRepository.findById(id).get();
    }

    @Override
    public DeliveryModel createDelivery(DeliveryModel delivery) {
        return deliveryModelRepository.save(delivery);
    }

    @Override
    public DeliveryModel updateDelivery(DeliveryModel delivery) {
        return deliveryModelRepository.save(delivery);
    }

    @Override
    public void deleteDelivery(Long id) {
        deliveryModelRepository.deleteById(id);
    }
}
