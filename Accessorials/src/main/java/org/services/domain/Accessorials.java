package org.services.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "accessorial")
public class Accessorials {

    @Id
    @Column(name = "accessorial_id")
    private String accessorialId;

    @Column(name = "accessorial_type")
    private String accessorialType;

    @Column(name = "description")
    private String description;

    @Column(name = "created_on")
    private Timestamp createdOn;

    @Column(name = "created_by")
    private String createdBy;
}
