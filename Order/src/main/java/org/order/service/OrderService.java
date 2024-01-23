package org.order.service;

import org.order.domain.Order;
import org.order.domain.OrderDetailsDTO;
import org.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<OrderDetailsDTO> getAllOrdersWithDetails() {
        return orderRepository.findAllOrdersWithDetails();
    }

    public OrderDetailsDTO getOrderWithDetailsById(Long id) {
        return orderRepository.findOrderWithDetailsById(id).orElse(null);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Long deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return id;
        } else {
            return null;
        }
    }
}
