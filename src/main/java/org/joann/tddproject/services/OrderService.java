package org.joann.tddproject.services;

import jakarta.transaction.Transactional;
import org.joann.tddproject.models.Order;
import org.joann.tddproject.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // CREATE - Save a new Order
    public Order createOrder(Order order) {
        return orderRepository.save(order); // Saves the order to the database
    }

    // READ - Find an Order by its ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id); // Fetches an Order by its ID
    }

    // READ - Get a list of all Orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll(); // Fetches all Orders from the database
    }

    // UPDATE - Update an existing Order
    @Transactional
    public Order updateOrder(Long id, Order updatedOrder) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    existingOrder.setCustomerName(updatedOrder.getCustomerName());
                    existingOrder.setOrderDate(updatedOrder.getOrderDate());
                    existingOrder.setShippingAddress(updatedOrder.getShippingAddress());
                    existingOrder.setTotal(updatedOrder.getTotal());
                    return orderRepository.save(existingOrder); // Updates and saves the Order
                })
                .orElseThrow(() -> new RuntimeException("Order not found with id " + id));
    }

    // DELETE - Delete an Order by its ID
    public void deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id); // Deletes the Order if it exists
        } else {
            throw new RuntimeException("Order not found with id " + id);
        }
    }
}
