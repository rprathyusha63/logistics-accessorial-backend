package org.order.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "service")
public class Services {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "service_display_name")
    private String serviceDisplayName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String serviceDescription;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "createdOn")
    private Timestamp createdOn;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "modifiedOn")
    private Timestamp modifiedOn;

    @Column(name = "modifiedBy")
    private String modifiedBy;

    @Column(name = "uom")
    private String uom;
}
