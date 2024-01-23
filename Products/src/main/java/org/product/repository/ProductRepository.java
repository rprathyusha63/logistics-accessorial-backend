package org.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.product.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
