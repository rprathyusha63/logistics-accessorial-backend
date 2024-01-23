package org.order.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "description")
	private String productDescription;

	@Column(name = "batch")
	private int batchID;

	@Column(name = "category")
	private String category;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "weight")
	private int weight;

	@Column(name = "dimensions")
	private int dimensions;

	@Column(name = "storage_condition")
	private String storageConditions;
}
