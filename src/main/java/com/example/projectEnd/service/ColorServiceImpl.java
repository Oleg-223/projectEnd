package com.example.projectEnd.service;

import com.example.projectEnd.model.ColorModel;
import com.example.projectEnd.repository.ColorModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService{
    private final ColorModelRepository colorRepository;

    public ColorServiceImpl(ColorModelRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public List<ColorModel> findAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public ColorModel findColorById(Long id) {
        return colorRepository.findById(id).get();
    }

    @Override
    public ColorModel createColor(ColorModel color) {
        return colorRepository.save(color);
    }

    @Override
    public ColorModel updateColor(ColorModel color) {
        return colorRepository.save(color);
    }

    @Override
    public void deleteColor(Long id) {
        colorRepository.deleteById(id);
    }
}
