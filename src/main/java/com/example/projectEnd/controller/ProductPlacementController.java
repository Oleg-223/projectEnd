package com.example.projectEnd.controller;

import com.example.projectEnd.model.ProductPlacementModel;
import com.example.projectEnd.service.ProductPlacementService;
import com.example.projectEnd.service.ProductService;
import com.example.projectEnd.service.StorageCellService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product-placements")
public class ProductPlacementController {

    private final ProductPlacementService productPlacementService;
    private final ProductService productService;
    private final StorageCellService storageCellService;

    public ProductPlacementController(
            ProductPlacementService productPlacementService,
            ProductService productService,
            StorageCellService storageCellService
    ) {
        this.productPlacementService = productPlacementService;
        this.productService = productService;
        this.storageCellService = storageCellService;
    }

    @GetMapping
    public String getAllProductPlacements(Model model) {
        var productPlacements = productPlacementService.findAllProductPlacement();
        model.addAttribute("productPlacements", productPlacements);
        return "product-placements/index";
    }

    @GetMapping("/create")
    public String getCreateProductPlacement(Model model) {
        model.addAttribute("productPlacementModel", new ProductPlacementModel());
        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("storageCells", storageCellService.findAllStorageCell());
        return "product-placements/create";
    }

    @PostMapping("/create")
    public String postCreateProductPlacement(
            @ModelAttribute("productPlacementModel") ProductPlacementModel productPlacementModel,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.findAllProduct());
            model.addAttribute("storageCells", storageCellService.findAllStorageCell());
            return "product-placements/create";
        }
        productPlacementService.createProductPlacement(productPlacementModel);
        return "redirect:/product-placements";
    }

    @GetMapping("/edit/{id}")
    public String editProductPlacement(@PathVariable("id") Long id, Model model) {
        ProductPlacementModel productPlacement = productPlacementService.findProductPlacementById(id);
        model.addAttribute("productPlacementModel", productPlacement);
        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("storageCells", storageCellService.findAllStorageCell());
        return "product-placements/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateProductPlacement(@PathVariable("id") Long id, @ModelAttribute("productPlacementModel") ProductPlacementModel productPlacementModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("products", productService.findAllProduct());
            model.addAttribute("storageCells", storageCellService.findAllStorageCell());
            return "product-placements/edit";
        }

        ProductPlacementModel existingProductPlacement = productPlacementService.findProductPlacementById(id);
        existingProductPlacement.setProduct(productPlacementModel.getProduct());
        existingProductPlacement.setStorageCell(productPlacementModel.getStorageCell());
        existingProductPlacement.setQuantity(productPlacementModel.getQuantity());

        productPlacementService.updateProductPlacement(existingProductPlacement);

        return "redirect:/product-placements";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductPlacement(@PathVariable("id") Long id) {
        productPlacementService.deleteProductPlacement(id);
        return "redirect:/product-placements";
    }
}
