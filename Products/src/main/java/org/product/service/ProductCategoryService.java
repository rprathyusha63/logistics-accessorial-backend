package org.product.service;

import org.product.domain.Product;
import org.product.domain.ProductCategory;
import org.product.repository.ProductCategoryRepository;
import org.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {

	private final ProductCategoryRepository productCategoryRepository;

	@Autowired
	public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
		this.productCategoryRepository = productCategoryRepository;
	}

	public List<ProductCategory> getAllCategories() {
		return productCategoryRepository.findAll();
	}

	}
