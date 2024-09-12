package org.joann.tddproject;

import org.joann.tddproject.models.Order;
import org.joann.tddproject.repositories.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    // Create operation test
    @Test
    public void testSaveOrder() {
        // Arrange: Create an Order object with all required fields
        Order order = new Order();
        order.setCustomerName("J");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("123 Main St, Wilmington, NC");
        order.setTotal(200.00);

        // Act: save the order object to the repository
        Order savedOrder = orderRepository.save(order);

        //Assert: Verify that the Order was saved correctly by checking the presence in the database
        Optional<Order> foundOrder = orderRepository.findById(savedOrder.getId());
        assertTrue(foundOrder.isPresent(), "The order should be saved and found in the database.");

        //Additional assertions to check the saved Order's fields
        assertEquals(order.getCustomerName(), foundOrder.get().getCustomerName(), "The customer name should be the same.");
        assertEquals(order.getOrderDate(), foundOrder.get().getOrderDate(), "The order date should be the same.");
        assertEquals(order.getShippingAddress(), foundOrder.get().getShippingAddress(), "The shipping address should be the same.");
        assertEquals(order.getTotal(), foundOrder.get().getTotal(), "The total should be the same.");
    }

    // READ operation test
    @Test
    public void testGetOrderById() {
        // Arrange: Create and save an Order
        Order order = new Order();
        order.setCustomerName("J");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("123 Main St, Wilmington, NC");
        order.setTotal(200.00);
        Order savedOrder = orderRepository.save(order);

        // Act: Retrieve the Order by ID
        Optional<Order> foundOrder = orderRepository.findById(savedOrder.getId());

        // Assert: Ensure the order was found and matches the saved order
        assertTrue(foundOrder.isPresent());
        assertEquals("J", foundOrder.get().getCustomerName());
    }

    // UPDATE operation test
    @Test
    public void testUpdateOrder() {
        // Arrange: Create and save an Order
        Order order = new Order();
        order.setCustomerName("Alice Doe");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("789 Maple St, Wilmington, NC");
        order.setTotal(300.00);
        Order savedOrder = orderRepository.save(order);

        // Act: Update the saved Order
        savedOrder.setCustomerName("Alice Johnson");
        savedOrder.setTotal(350.00);
        Order updatedOrder = orderRepository.save(savedOrder);

        // Assert: Ensure the Order was updated correctly
        Optional<Order> foundOrder = orderRepository.findById(updatedOrder.getId());
        assertTrue(foundOrder.isPresent());
        assertEquals("Alice Johnson", foundOrder.get().getCustomerName());
        assertEquals(350.00, foundOrder.get().getTotal());
    }

    // DELETE operation test
    @Test
    public void testDeleteOrder() {
        // Arrange: Create and save an Order
        Order order = new Order();
        order.setCustomerName("Bob Smith");
        order.setOrderDate(LocalDate.now());
        order.setShippingAddress("123 Pine St, Wilmington, NC");
        order.setTotal(500.00);
        Order savedOrder = orderRepository.save(order);

        // Act: Delete the Order
        orderRepository.deleteById(savedOrder.getId());

        // Assert: Ensure the Order was deleted
        Optional<Order> deletedOrder = orderRepository.findById(savedOrder.getId());
        assertFalse(deletedOrder.isPresent());
    }
}
