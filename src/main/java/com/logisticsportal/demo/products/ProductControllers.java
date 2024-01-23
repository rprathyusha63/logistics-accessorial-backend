package com.logisticsportal.demo.products;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logisticsportal.demo.products.*;

@RestController
@CrossOrigin(origins = "*")
public class ProductControllers {

	@Autowired
	ProductService productService;

	@GetMapping("/products")
	public List<Product> getProducts() {

		return productService.getAllProducts();
	}

	@GetMapping("/products/{id}")
	public Product getProductbyId(@PathVariable(value = "id") int id) {

		Product product = productService.getProductbyID(id);
		return product;

	}

	// @GetMapping("/products/{productName}")
	// public Product getProductbyName(@RequestParam(value="name") String
	// productName) {
	//
	// return productService.getProductbyName(productName);
	// }
	//
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {

		return productService.addProduct(product);
	}

	@PutMapping("/updateproduct")
	public Product updateProduct(@PathVariable(value = "id") int id, @RequestBody Product product) {

		// return productService.updateProduct(product);
		try {
			Product existProduct = productService.getProductbyID(id);
			existProduct.setProductName(product.getProductName());
			existProduct.setBatchID(product.getBatchID());
			existProduct.setCategory(product.getCategory());
			existProduct.setDesc(product.getDesc());
			existProduct.setDimensions(product.getDimensions());
			existProduct.setStorageConditions(product.getStorageConditions());
			existProduct.setWeight(product.getWeight());
			existProduct.setManufacturer(product.getManufacturer());

			Product updatedproduct = productService.updateProduct(existProduct);
			return updatedproduct;
		} catch (Exception e) {
			return null;
		}

	}

	@DeleteMapping("/deleteproduct/{id}")
	public AddResponse deleteProduct(@PathVariable(value = "id") int id) {

		return productService.deleteProduct(id);
	}

}

// @GetMapping("/products")
// public List getProducts() {
//
// return productService.getAllProducts();
// }
//
// @GetMapping("/products/{id}")
// public Product getProductbyId(@PathVariable(value="id") int id) {
//
// return productService.getProductbyID(id);
// }
//// @GetMapping("/products/{productName}")
//// public Product getProductbyName(@RequestParam(value="name") String
// productName) {
////
//// return productService.getProductbyName(productName);
//// }
////
// @PostMapping("/addproduct")
// public Product addProduct(@RequestBody Product product) {
//
// return productService.addProduct(product);
// }
// @PutMapping("/updateproduct")
// public Product updateProduct(@RequestBody Product product) {
//
// return productService.updateProduct(product);
// }
// @DeleteMapping("/deleteproduct/{id}")
// public AddResponse deleteProduct(@PathVariable(value="id") int id) {
//
// return productService.deleteProduct(id);
// }
