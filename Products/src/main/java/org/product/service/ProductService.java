package org.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.product.domain.Product;
import org.product.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductbyID(int productID) {
		return productRepository.findById(productID).get();
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product) {
		productRepository.save(product);
		return product;
	}

	public int deleteProduct(int productID) {
		if (productRepository.existsById(productID)) {
			productRepository.deleteById(productID);
			return productID;
		} else {
			return 0;
		}
	}
}
