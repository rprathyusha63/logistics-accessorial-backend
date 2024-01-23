package com.logisticsportal.demo.repositories;
import org.springframework.data.jpa.repository.*;

import com.logisticsportal.demo.products.*;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
