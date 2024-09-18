package com.example.projectEnd.service;

import com.example.projectEnd.model.SupplierModel;

import java.util.List;

public interface SupplierService {
    List<SupplierModel> findAllSupplier();
    SupplierModel findSupplierById(Long id);
    SupplierModel createSupplier(SupplierModel supplier);
    SupplierModel updateSupplier(SupplierModel supplier);
    void deleteSupplier(Long id);
}
