package org.product.controller;

import org.product.domain.ProductCategory;
import org.product.service.ProductCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.product.domain.Product;
import org.product.service.ProductService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/products")
public class ProductControllers {
	private final ProductService productService;


	@Autowired
	public ProductControllers(ProductService productService, ProductCategoryService productCategoryService) {
		this.productService = productService;
	}

	@GetMapping
	public Flux<ResponseEntity<Product>> getProducts() {

		return Flux.fromIterable(productService.getAllProducts())
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}


	@GetMapping("/{productID}")
	public Mono<ResponseEntity<?>> getProduct(@PathVariable int productID) {
		Product product = productService.getProductbyID(productID);
		if (product != null) {
			return Mono.just(ResponseEntity.status(HttpStatus.OK).body(product));
		} else {
			return Mono
					.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with ID " + productID));
		}
	}

	// Create a Product
	@PostMapping
	public Mono<ResponseEntity<Product>> createProduct(@RequestBody Product product) {
		// product.setCreatedOn(new Timestamp(new Date().getTime()));
		// product.setModifiedOn(new Timestamp(new Date().getTime()));
		Product savedProduct = productService.saveProduct(product);
		return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedProduct));
	}

	@PutMapping("/{productID}")
	public Mono<ResponseEntity<?>> updateProduct(@PathVariable int productID, @RequestBody Product product) {
		Product existProduct = productService.getProductbyID(productID);
		if (existProduct != null) {
			existProduct.setProductModel(product.getProductModel());

			existProduct.setCategory(product.getCategory());
			existProduct.setBrand(product.getBrand());
			existProduct.setSize(product.getSize());
			existProduct.setWeight(product.getWeight());
			existProduct.setDimensions(product.getDimensions());
			existProduct.setSkuNumber(product.getSkuNumber());
			existProduct.setMaterial(product.getMaterial());
			existProduct.setNoOfPieces(product.getNoOfPieces());
			Product updatedProductEntity = productService.saveProduct(existProduct);

			return Mono.just(ResponseEntity.ok(updatedProductEntity));
		} else {
			return Mono
					.just(ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with ID: " + productID));
		}
	}

	// Delete a Product
	@DeleteMapping("/{id}")
	public Mono<ResponseEntity<String>> deleteProduct(@PathVariable int id) {
		int deletedId = productService.deleteProduct(id);

		if (deletedId != 0) {
			return Mono.just(ResponseEntity.status(HttpStatus.OK)
					.body("Product with ID: " + deletedId + " has been deleted."));
		} else {
			return Mono.just(ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("Product not found with ID: " + id));
		}
	}
}