package com.logisticsportal.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logisticsportal.demo.entity.Product;
import com.logisticsportal.demo.services.ProductService;


@RestController
public class ProductControllers {
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/products")
	public List getProducts() {
		
		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{id}") 
	public Product getProductbyId(@PathVariable(value="id") int id) {
		
		return productService.getProductbyID(id);
	}
//	@GetMapping("/products/{productName}") 
//	public Product getProductbyName(@RequestParam(value="name") String productName) {
//		
//		return productService.getProductbyName(productName);
//	}
//	
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		
		return productService.addProduct(product);
	}
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) {
		
		return productService.updateProduct(product);
	}
	@DeleteMapping("/deleteproduct/{id}")
	public AddResponse deleteProduct(@PathVariable(value="id") int id) {
		
		return productService.deleteProduct(id);
	}
	
	}

