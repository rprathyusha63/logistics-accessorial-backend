package org.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class OrderDetailsDTO {
    private Long orderId;
    private Long warehouseId;
    private Long customerId;
    private Long serviceId;
    private Long productId;
    private String uom;
    private Long quantity;
    private Double rate;
    private Order.OrderStatus status;
    private Timestamp createdOn;
    private String createdBy;
    private Long total;
    private String currency;
    private String warehouseName;
    private String warehouseLocation;
    private String customerFirstName;
    private String customerLastName;
    private String productName;
    private String productDescription;
    private String serviceDisplayName;
    private String serviceDescription;
}