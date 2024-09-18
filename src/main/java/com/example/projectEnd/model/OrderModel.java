package com.example.projectEnd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Не может быть пустым")
    @ManyToOne(cascade = CascadeType.ALL)
    private CustomerModel customer;

    @NotNull(message = "Не может быть пустым")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ProductModel> products;

    @NotNull(message = "Не может быть пустым")
    private LocalDate orderDate;

    @NotNull(message = "Не может быть пустым")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Не может быть пустым") CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(@NotNull(message = "Не может быть пустым") CustomerModel customer) {
        this.customer = customer;
    }

    public @NotNull(message = "Не может быть пустым") List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(@NotNull(message = "Не может быть пустым") List<ProductModel> products) {
        this.products = products;
    }

    public @NotNull(message = "Не может быть пустым") LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(@NotNull(message = "Не может быть пустым") LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public @NotNull(message = "Не может быть пустым") String getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "Не может быть пустым") String status) {
        this.status = status;
    }
}
