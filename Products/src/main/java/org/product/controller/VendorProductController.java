package org.product.controller;

import org.product.domain.Product;
import org.product.domain.ProductCategory;
import org.product.domain.VendorProduct;
import org.product.service.ProductCategoryService;
import org.product.service.ProductService;
import org.product.service.VendorProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping("/vendorproducts")
public class VendorProductController {
	private final VendorProductService vendorProductService;


	@Autowired
	public VendorProductController(VendorProductService vendorProductService) {
		this.vendorProductService = vendorProductService;
	}

	@GetMapping
	public Flux<ResponseEntity<VendorProduct>> getVendorProducts() {

		return Flux.fromIterable(vendorProductService.getAllVendorProducts())
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
	@GetMapping("/{vendor_id}")
	public Flux<ResponseEntity<VendorProduct>> getVendorProductsByVendorId(@PathVariable String vendor_id) {

		return Flux.fromIterable(vendorProductService.getAllVendorProductsByVendorId(vendor_id))
				.map(ResponseEntity::ok)
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}

	@PostMapping()
	public Mono<ResponseEntity<VendorProduct>> getVendorProductsByVendorId(@RequestBody VendorProduct VendorProduct) {

		VendorProduct savedVendorProduct =  vendorProductService.saveVendorProduct(VendorProduct);
		return Mono.just(ResponseEntity.status(HttpStatus.CREATED).body(savedVendorProduct));
	}

}