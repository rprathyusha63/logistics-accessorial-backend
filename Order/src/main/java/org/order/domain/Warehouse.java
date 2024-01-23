package org.order.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id")
    private Long warehouseId;

    @Column(name = "warehouse_name")
    private String warehouseName;

    @Column(name = "location")
    private String warehouseLocation;

    @Column(name = "warehouse_manager")
    private String warehouseManager;

    @Column(name = "warehouse_contact_number")
    private String warehouseContactNumber;

    @Column(name = "warehouse_email")
    private String warehouseEmail;

    @Column(name = "capacity")
    private int warehouseCapacity;

    @Column(name = "warehouse_type")
    private String warehouseType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private WarehouseStatus warehouseStatus;

    @Column(name = "operating_hours")
    private String warehouseOperatingHours;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_on")
    private Timestamp modifiedOn;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "notes")
    private String notes;

    public enum WarehouseStatus {
        ACTIVE,
        INACTIVE,
        UNDER_MAINTENANCE,
        OTHER_STATUS
    }
}
