package org.product.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {

	@Id
	@Column(name = "product_id")
	private int productID;

	@Column(name = "product_model")
	private String productModel;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category", referencedColumnName = "category_name", insertable = false, updatable = false)
	private ProductCategory category;

	@Column(name = "brand")
	private String brand;

	@Column(name = "size")
	private String size;

	@Column(name = "weight")
	private String weight;

	@Column(name = "dimensions")
	private String dimensions;

	@Column(name = "sku_or_item_number")
	private String skuNumber;

	@Column(name = "material")
	private String material;

	@Column(name = "no_of_pieces")
	private String noOfPieces;
}
