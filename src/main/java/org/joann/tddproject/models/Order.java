package org.joann.tddproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name is mandatory")
    private String customerName;

    @Column(nullable = false)
    private LocalDate orderDate;

    @NotBlank(message = "Shipping address is mandatory")
    private String shippingAddress;

    @PositiveOrZero(message = "Total must be a positive value")
    private Double total;

    //Default constructor
    public Order() {

    }

    // Constructor with parameters
    public Order(String customerName, LocalDate orderDate, String shippingAddress, Double total) {
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.shippingAddress = shippingAddress;
        this.total = total;
    }

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    // Overrirde toString() for better logging and debugging
    public String toString() {
        return "Order{" + "id=" + id + "\ncustomerName=" + customerName + "\norderDate=" + orderDate + "\nshippingAddress=" + shippingAddress + "\ntotal=" + total + '}';
    }
}
