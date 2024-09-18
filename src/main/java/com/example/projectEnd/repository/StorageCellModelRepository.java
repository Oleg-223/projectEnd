package com.example.projectEnd.repository;

import com.example.projectEnd.model.StorageCellModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StorageCellModelRepository extends JpaRepository<StorageCellModel,Long> {
}
