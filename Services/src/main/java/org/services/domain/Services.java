package org.services.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "services")
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

    @Column(name = "currency")
    private String currency;

    @Column(name = "rate")
    private double rate;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_on")
    private Timestamp modifiedOn;

    @Column(name = "modified_by")
    private String modifiedBy;

}
