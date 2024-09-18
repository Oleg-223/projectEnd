package com.example.projectEnd.service;

import com.example.projectEnd.model.ColorModel;

import java.util.List;

public interface ColorService {
    List<ColorModel> findAllColors();
    ColorModel findColorById(Long id);
    ColorModel createColor(ColorModel color);
    ColorModel updateColor(ColorModel color);
    void deleteColor(Long id);
}