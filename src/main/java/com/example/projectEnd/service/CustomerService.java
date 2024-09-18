package com.example.projectEnd.service;

import com.example.projectEnd.model.CustomerModel;

import java.util.List;

public interface CustomerService {
    List<CustomerModel> findAllCustomer();
    CustomerModel findCustomerById(Long id);
    CustomerModel createCustomer(CustomerModel customer);
    CustomerModel updateCustomer(CustomerModel customer);
    void deleteCustomer(Long id);
}
