package com.example.projectEnd.controller;

import com.example.projectEnd.model.StorageCellModel;
import com.example.projectEnd.service.StorageCellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/storage-cells")
public class StorageCellController {

    private final StorageCellService storageCellService;

    @Autowired
    public StorageCellController(StorageCellService storageCellService) {
        this.storageCellService = storageCellService;
    }

    @GetMapping
    public String getAllStorageCells(Model model) {
        model.addAttribute("storageCells", storageCellService.findAllStorageCell());
        return "storage-cells/index";
    }

    @GetMapping("/create")
    public String getCreateStorageCellForm(Model model) {
        model.addAttribute("storageCell", new StorageCellModel());
        return "storage-cells/create";
    }

    @PostMapping("/create")
    public String createStorageCell(@Valid @ModelAttribute("storageCell") StorageCellModel storageCell, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "storage-cells/create";
        }
        storageCellService.createStorageCell(storageCell);
        return "redirect:/storage-cells";
    }

    @GetMapping("/edit/{id}")
    public String getEditStorageCellForm(@PathVariable("id") Long id, Model model) {
        StorageCellModel storageCell = storageCellService.findStorageCellById(id);
        model.addAttribute("storageCell", storageCell);
        return "storage-cells/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateStorageCell(@PathVariable("id") Long id, @Valid @ModelAttribute("storageCell") StorageCellModel storageCell, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "storage-cells/edit";
        }

        StorageCellModel existingStorageCell = storageCellService.findStorageCellById(id);
        existingStorageCell.setCellNumber(storageCell.getCellNumber());
        existingStorageCell.setLocation(storageCell.getLocation());

        storageCellService.updateStorageCell(existingStorageCell);

        return "redirect:/storage-cells";
    }

    @GetMapping("/delete/{id}")
    public String deleteStorageCell(@PathVariable("id") Long id) {
        storageCellService.deleteStorageCell(id);
        return "redirect:/storage-cells";
    }
}
