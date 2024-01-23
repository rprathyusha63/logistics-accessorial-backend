package org.product.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "vendor_product")
public class VendorProduct {

	@EmbeddedId
	private VendorProductId id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id", insertable = false, updatable = false)
	private Vendor vendor_id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
	private Product product_id;
	}
