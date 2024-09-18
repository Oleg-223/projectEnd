package com.example.projectEnd.controller;

import com.example.projectEnd.model.DeliveryModel;
import com.example.projectEnd.service.DeliveryService;
import com.example.projectEnd.service.ProductService;
import com.example.projectEnd.service.SupplierService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private final ProductService productService;
    private final SupplierService supplierService;

    public DeliveryController(DeliveryService deliveryService, ProductService productService, SupplierService supplierService) {
        this.deliveryService = deliveryService;
        this.productService = productService;
        this.supplierService = supplierService;
    }

    @GetMapping
    public String getAllDeliveries(Model model) {
        var deliveries = deliveryService.findAllDelivery();
        model.addAttribute("deliveries", deliveries);
        return "deliveries/index";
    }

    @GetMapping("/create")
    public String getCreateDelivery(Model model) {
        model.addAttribute("deliveryModel", new DeliveryModel());
        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("suppliers", supplierService.findAllSupplier());
        return "deliveries/create";
    }


    @PostMapping("/create")
    public String postCreateDelivery(
            @ModelAttribute("deliveryModel") DeliveryModel deliveryModel,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            return "deliveries/create";
        }
        deliveryService.createDelivery(deliveryModel);
        return "redirect:/deliveries";
    }

    @GetMapping("/edit/{id}")
    public String editDelivery(@PathVariable("id") Long id, Model model) {
        DeliveryModel delivery = deliveryService.findDeliveryById(id);
        model.addAttribute("deliveryModel", delivery);
        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("suppliers", supplierService.findAllSupplier());
        return "deliveries/edit";
    }



    @PostMapping("/edit/{id}")
    public String updateDelivery(@PathVariable("id") Long id, @ModelAttribute("deliveryModel") DeliveryModel deliveryModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "deliveries/edit";
        }

        DeliveryModel existingDelivery = deliveryService.findDeliveryById(id);
        existingDelivery.setProducts(deliveryModel.getProducts());
        existingDelivery.setSuppliers(deliveryModel.getSuppliers());
        existingDelivery.setDeliveryDate(deliveryModel.getDeliveryDate());
        existingDelivery.setQuantity(deliveryModel.getQuantity());

        deliveryService.updateDelivery(existingDelivery);

        return "redirect:/deliveries";
    }

    @GetMapping("/delete/{id}")
    public String deleteDelivery(@PathVariable("id") Long id) {
        deliveryService.deleteDelivery(id);
        return "redirect:/deliveries";
    }
}
