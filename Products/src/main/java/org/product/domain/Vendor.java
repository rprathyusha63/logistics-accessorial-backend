package org.product.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vendor")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vendor_id")
    private Long vendor_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "warehouse_id", insertable = false, updatable = false)
    private Warehouse warehouse;

    @Column(name = "vendor_business_name")
    private String businessName;

    @Column(name = "vendor_first_name")
    private String firstName;

    @Column(name = "vendor_last_name")
    private String lastName;

    @Column(name = "vendor_type")
    private String type;

    @Column(name = "vendor_email")
    private String email;

    @Column(name = "vendor_phone")
    private String phone;

    @Column(name = "vendor_address")
    private String address;

    @Column(name = "notes")
    private String notes;

}
