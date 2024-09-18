package com.example.projectEnd.controller;

import com.example.projectEnd.model.CustomerModel;
import com.example.projectEnd.model.OrderModel;
import com.example.projectEnd.model.ProductModel;
import com.example.projectEnd.service.CustomerService;
import com.example.projectEnd.service.OrderService;
import com.example.projectEnd.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final CustomerService customerService;

    public OrderController(OrderService orderService, ProductService productService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        var orders = orderService.findAllOrder();
        model.addAttribute("orders", orders);
        return "orders/index";
    }

    @GetMapping("/create")
    public String getCreateOrder(Model model) {
        model.addAttribute("orderModel", new OrderModel());
        List<CustomerModel> customers = customerService.findAllCustomer();
        model.addAttribute("customers", customers);
        List<ProductModel> products = productService.findAllProduct();
        model.addAttribute("products", products);
        return "orders/create";
    }


    @PostMapping("/create")
    public String postCreateOrder(
            @ModelAttribute("orderModel") OrderModel orderModel,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            List<CustomerModel> customers = customerService.findAllCustomer();
            model.addAttribute("customers", customers);
            List<ProductModel> products = productService.findAllProduct();
            model.addAttribute("products", products);
            return "orders/create";
        }
        orderService.createOrder(orderModel);
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String editOrder(@PathVariable("id") Long id, Model model) {
        OrderModel order = orderService.findOrderById(id);
        model.addAttribute("orderModel", order);
        List<CustomerModel> customers = customerService.findAllCustomer();
        model.addAttribute("customers", customers);
        List<ProductModel> products = productService.findAllProduct();
        model.addAttribute("products", products);
        return "orders/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateOrder(@PathVariable("id") Long id, @ModelAttribute("orderModel") OrderModel orderModel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<CustomerModel> customers = customerService.findAllCustomer();
            model.addAttribute("customers", customers);
            List<ProductModel> products = productService.findAllProduct();
            model.addAttribute("products", products);
            return "orders/edit";
        }

        OrderModel existingOrder = orderService.findOrderById(id);
        existingOrder.setCustomer(orderModel.getCustomer());
        existingOrder.setProducts(orderModel.getProducts());
        existingOrder.setOrderDate(orderModel.getOrderDate());
        existingOrder.setStatus(orderModel.getStatus());

        orderService.updateOrder(existingOrder);

        return "redirect:/orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }
}
