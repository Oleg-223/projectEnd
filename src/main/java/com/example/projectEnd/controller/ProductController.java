package com.example.projectEnd.controller;

import com.example.projectEnd.model.ColorModel;
import com.example.projectEnd.model.ProductModel;
import com.example.projectEnd.service.ColorService;
import com.example.projectEnd.service.ProductService;
import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ColorService colorService;

    public ProductController(ProductService productService, ColorService colorService) {
        this.productService = productService;
        this.colorService = colorService;
    }


    @GetMapping
    public String getAllProducts(Model model) {
        var products = productService.findAllProduct();
        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping("/create")
    public String getCreateProduct(Model model) {
        model.addAttribute("productModel", new ProductModel());
        model.addAttribute("colors", colorService.findAllColors());
        return "products/create";
    }

    @PostMapping("/create")
    public String postCreateProduct(
            @ModelAttribute("productModel") ProductModel productModel,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("colors", colorService.findAllColors());
            return "products/create";
        }
        ColorModel selectedColor = colorService.findColorById(productModel.getColor().getId());
        productModel.setColor(selectedColor);
        productService.createProduct(productModel);
        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        ProductModel product = productService.findProductById(id);
        model.addAttribute("productModel", product);
        model.addAttribute("colors", colorService.findAllColors());
        return "products/edit";
    }


    @PostMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") Long id, @ModelAttribute("productModel") ProductModel productModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("colors", colorService.findAllColors());
            return "products/edit";
        }

        ProductModel existingProduct = productService.findProductById(id);
        existingProduct.setName(productModel.getName());
        existingProduct.setDescription(productModel.getDescription());
        existingProduct.setPrice(productModel.getPrice());
        existingProduct.setQuantity(productModel.getQuantity());
        ColorModel selectedColor = colorService.findColorById(productModel.getColor().getId());
        existingProduct.setColor(selectedColor);

        productService.updateProduct(existingProduct);

        return "redirect:/products";
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/products";
    }
}
