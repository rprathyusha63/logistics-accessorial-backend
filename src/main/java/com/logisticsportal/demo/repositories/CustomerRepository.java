package com.logisticsportal.demo.repositories;

import org.springframework.data.jpa.repository.*;

import com.logisticsportal.demo.customers.*;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

