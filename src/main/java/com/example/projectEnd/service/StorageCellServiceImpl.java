package com.example.projectEnd.service;

import com.example.projectEnd.model.StorageCellModel;
import com.example.projectEnd.repository.StorageCellModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageCellServiceImpl implements StorageCellService {
    private final StorageCellModelRepository storageCellModelRepository;

    public StorageCellServiceImpl(StorageCellModelRepository storageCellModelRepository) {
        this.storageCellModelRepository = storageCellModelRepository;
    }

    @Override
    public List<StorageCellModel> findAllStorageCell() {
        return storageCellModelRepository.findAll();
    }

    @Override
    public StorageCellModel findStorageCellById(Long id) {
        return storageCellModelRepository.findById(id).get();
    }

    @Override
    public StorageCellModel createStorageCell(StorageCellModel storageCell) {
        return storageCellModelRepository.save(storageCell);
    }

    @Override
    public StorageCellModel updateStorageCell(StorageCellModel storageCell) {
        return storageCellModelRepository.save(storageCell);
    }

    @Override
    public void deleteStorageCell(Long id) {
        storageCellModelRepository.deleteById(id);
    }
}
