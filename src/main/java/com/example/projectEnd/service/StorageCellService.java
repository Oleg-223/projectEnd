package com.example.projectEnd.service;

import com.example.projectEnd.model.StorageCellModel;

import java.util.List;

public interface StorageCellService {
    List<StorageCellModel> findAllStorageCell();
    StorageCellModel findStorageCellById(Long id);
    StorageCellModel createStorageCell(StorageCellModel storageCell);
    StorageCellModel updateStorageCell(StorageCellModel storageCell);
    void deleteStorageCell(Long id);
}
