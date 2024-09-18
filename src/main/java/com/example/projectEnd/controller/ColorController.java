package com.example.projectEnd.controller;

import com.example.projectEnd.model.ColorModel;
import com.example.projectEnd.service.ColorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/colors")
public class ColorController {

    private final ColorService colorService;

    public ColorController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping
    public String getAllColors(Model model) {
        var colors = colorService.findAllColors();
        model.addAttribute("colors", colors);
        return "colors/index";
    }

    @GetMapping("/create")
    public String getCreateColor(Model model) {
        model.addAttribute("colorModel", new ColorModel());
        return "colors/create";
    }

    @PostMapping("/create")
    public String postCreateColor(
            @ModelAttribute("colorModel") ColorModel colorModel,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "colors/create";
        }
        colorService.createColor(colorModel);
        return "redirect:/colors";
    }

    @GetMapping("/edit/{id}")
    public String editColor(@PathVariable("id") Long id, Model model) {
        ColorModel color = colorService.findColorById(id);
        model.addAttribute("colorModel", color);
        return "colors/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateColor(@PathVariable("id") Long id, @ModelAttribute("colorModel") ColorModel colorModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "colors/edit";
        }

        ColorModel existingColor = colorService.findColorById(id);
        existingColor.setColorName(colorModel.getColorName());

        colorService.updateColor(existingColor);

        return "redirect:/colors";
    }

    @GetMapping("/delete/{id}")
    public String deleteColor(@PathVariable("id") Long id) {
        colorService.deleteColor(id);
        return "redirect:/colors";
    }
}
