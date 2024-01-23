package org.order.repository;

import org.order.domain.Order;
import org.order.domain.OrderDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT new org.order.domain.OrderDetailsDTO("
            + "o.orderId, "
            + "o.warehouse.warehouseId, "
            + "o.customer.customerId, "
            + "o.service.serviceId, "
            + "o.product.productId, "
            + "o.uom, "
            + "o.quantity, "
            + "o.rate, "
            + "o.status, "
            + "o.createdOn, "
            + "o.createdBy, "
            + "o.total, "
            + "o.currency, "
            + "w.warehouseName, "
            + "w.warehouseLocation, "
            + "c.customerFirstName, "
            + "c.customerLastName, "
            + "p.productName, "
            + "p.productDescription, "
            + "s.serviceDisplayName, "
            + "s.serviceDescription) "
            + "FROM Order o "
            + "JOIN o.warehouse w "
            + "JOIN o.customer c "
            + "JOIN o.product p "
            + "JOIN o.service s")
    List<OrderDetailsDTO> findAllOrdersWithDetails();


    @Query("SELECT new org.order.domain.OrderDetailsDTO("
            + "o.orderId, "
            + "o.warehouse.warehouseId, "
            + "o.customer.customerId, "
            + "o.service.serviceId, "
            + "o.product.productId, "
            + "o.uom, "
            + "o.quantity, "
            + "o.rate, "
            + "o.status, "
            + "o.createdOn, "
            + "o.createdBy, "
            + "o.total, "
            + "o.currency, "
            + "w.warehouseName, "
            + "w.warehouseLocation, "
            + "c.customerFirstName, "
            + "c.customerLastName, "
            + "p.productName, "
            + "p.productDescription, "
            + "s.serviceDisplayName, "
            + "s.serviceDescription) "
            + "FROM Order o "
            + "JOIN o.warehouse w "
            + "JOIN o.customer c "
            + "JOIN o.product p "
            + "JOIN o.service s "
            + "WHERE o.orderId = :id")
    Optional<OrderDetailsDTO> findOrderWithDetailsById(@Param("id") Long id);

}
