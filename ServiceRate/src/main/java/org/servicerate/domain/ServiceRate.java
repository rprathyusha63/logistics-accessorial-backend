package org.servicerate.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "service_rate")
public class ServiceRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_rate_id")
    private Long serviceRateId;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "currency")
    private String currency;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "effective_date")
    private Timestamp effectiveDate;

    @Column(name = "expiration_date")
    private Timestamp expirationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public enum Status {
        ACTIVE, INACTIVE;
    }
}
