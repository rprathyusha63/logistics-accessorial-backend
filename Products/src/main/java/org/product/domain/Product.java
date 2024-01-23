package org.product.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productID;

	@Column(name = "product_name")
	private String productName;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category", referencedColumnName = "category_name", insertable = false, updatable = false)
	private ProductCategory category;

	@Column(name = "brand")
	private String brand;

	@Column(name = "description")
	private String desc;

	@Column(name = "gender")
	private String gender;

	@Column(name = "weight")
	private int weight;

	@Column(name = "dimensions")
	private String dimensions;

	@Column(name = "storage_condition")
	private String storageConditions;
}
