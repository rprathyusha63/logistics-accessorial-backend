package org.order.controller;

import org.order.domain.Order;
import org.order.domain.OrderDetailsDTO;
import org.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Get all Orders
    @GetMapping
    public Flux<ResponseEntity<OrderDetailsDTO>> getAllOrders() {
        return Flux.fromIterable(orderService.getAllOrdersWithDetails())
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Get Order by ID
    @GetMapping("/{id}")
    public Mono<ResponseEntity<OrderDetailsDTO>> getOrder(@PathVariable Long id) {
        OrderDetailsDTO orderDetails = orderService.getOrderWithDetailsById(id);
        return Mono.just(orderDetails)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    // Create an Order
    @PostMapping
    public Mono<ResponseEntity<Order>> createOrder(@RequestBody Order order) {
        order.setCreatedOn(new Timestamp(new Date().getTime()));
        Order savedOrder = orderService.saveOrder(order);
        return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedOrder));
    }

    // Update an Order
    @PutMapping("/{id}")
    public Mono<ResponseEntity<?>> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Order existingOrder = orderService.getOrderById(id);
        if (existingOrder != null) {
            // Update the properties of existingOrder with the values from updatedOrder
            existingOrder.setWarehouseId(updatedOrder.getWarehouseId());
            existingOrder.setCustomerId(updatedOrder.getCustomerId());
            existingOrder.setProductId(updatedOrder.getProductId());
            existingOrder.setServiceId(updatedOrder.getServiceId());
            existingOrder.setWarehouse(updatedOrder.getWarehouse());
            existingOrder.setVendor(updatedOrder.getVendor());
            existingOrder.setProduct(updatedOrder.getProduct());
            existingOrder.setService(updatedOrder.getService());
            existingOrder.setUom(updatedOrder.getUom());
            existingOrder.setQuantity(updatedOrder.getQuantity());
            existingOrder.setRate(updatedOrder.getRate());
            existingOrder.setStatus(updatedOrder.getStatus());
            existingOrder.setCurrency(updatedOrder.getCurrency());
            existingOrder.setTotal(updatedOrder.getTotal());

            Order updatedOrderEntity = orderService.saveOrder(existingOrder);

            return Mono.just(ResponseEntity.ok(updatedOrderEntity));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + id));
        }
    }

    // Delete an Order
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<String>> deleteOrder(@PathVariable Long id) {
        Long deletedId = orderService.deleteOrder(id);

        if (deletedId != null) {
            return Mono.just(ResponseEntity.status(HttpStatus.OK)
                    .body("Order with ID: " + deletedId + " has been deleted."));
        } else {
            return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Order not found with ID: " + id));
        }
    }
}