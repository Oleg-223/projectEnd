package com.example.projectEnd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="deliveries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Не может быть пустым")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<ProductModel> products;

    @NotNull(message = "Не может быть пустым")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SupplierModel> suppliers;

    @NotNull(message = "Не может быть пустым")
    private LocalDate deliveryDate;

    @Min(value = 1, message = "Не меньше 1")
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "Не может быть пустым") List<ProductModel> getProducts() {
        return products;
    }

    public void setProducts(@NotNull(message = "Не может быть пустым") List<ProductModel> products) {
        this.products = products;
    }

    public @NotNull(message = "Не может быть пустым") List<SupplierModel> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(@NotNull(message = "Не может быть пустым") List<SupplierModel> suppliers) {
        this.suppliers = suppliers;
    }

    public @NotNull(message = "Не может быть пустым") LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(@NotNull(message = "Не может быть пустым") LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Min(value = 1, message = "Не меньше 1")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(@Min(value = 1, message = "Не меньше 1") int quantity) {
        this.quantity = quantity;
    }
}
