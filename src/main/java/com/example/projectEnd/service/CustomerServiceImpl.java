package com.example.projectEnd.service;

import com.example.projectEnd.model.CustomerModel;
import com.example.projectEnd.repository.CustomerModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerModelRepository customerModelRepository;

    public CustomerServiceImpl(CustomerModelRepository customerModelRepository) {
        this.customerModelRepository = customerModelRepository;
    }

    @Override
    public List<CustomerModel> findAllCustomer() {
        return customerModelRepository.findAll();
    }

    @Override
    public CustomerModel findCustomerById(Long id) {
        return customerModelRepository.findById(id).get();
    }

    @Override
    public CustomerModel createCustomer(CustomerModel customer) {
        return customerModelRepository.save(customer);
    }

    @Override
    public CustomerModel updateCustomer(CustomerModel customer) {
        return customerModelRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerModelRepository.deleteById(id);
    }
}
