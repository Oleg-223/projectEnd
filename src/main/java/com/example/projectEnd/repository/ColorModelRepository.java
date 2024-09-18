package com.example.projectEnd.repository;

import com.example.projectEnd.model.ColorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorModelRepository extends JpaRepository<ColorModel,Long> {
}
