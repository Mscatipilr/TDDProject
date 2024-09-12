package org.joann.tddproject;

import jakarta.annotation.PostConstruct;
import org.joann.tddproject.models.Order;
import org.joann.tddproject.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TddProjectApplication {

    private final OrderService orderService;

    @Autowired
    public TddProjectApplication(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TddProjectApplication.class, args);
    }

    // This method will be called after the application context is initialized
    @PostConstruct
    public void createInitialOrder() {
        Order initialOrder = new Order("Initial Customer", LocalDate.now(), "123 Startup St", 99.99);
        orderService.createOrder(initialOrder);
        System.out.println("Initial order added to the database.");
    }

}
