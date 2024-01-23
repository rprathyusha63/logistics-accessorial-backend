package org.product.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VendorProductId implements Serializable {
    @Column(name = "vendor_id")
    private long vendor_id;

    @Column(name="product_id")
    private long product_id;

    public VendorProductId() {
    }

    public VendorProductId(long vendor_id, long product_id) {
        this.vendor_id = vendor_id;
        this.product_id = product_id;
    }

    // getters and setters...

    public long getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(long vendor_id) {
        this.vendor_id = vendor_id;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    // equals() and hashCode()...

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendorProductId that = (VendorProductId) o;
        return vendor_id == that.vendor_id && product_id == that.product_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendor_id, product_id);
    }
}
