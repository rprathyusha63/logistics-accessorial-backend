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
import org.springframework.web.bind.annotation.RestController;

import com.logisticsportal.demo.entity.Customer;
import com.logisticsportal.demo.entity.Product;
import com.logisticsportal.demo.services.CustomerService;
import com.logisticsportal.demo.services.ProductService;

@RestController
public class CustomerControllers {
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/customers")
	public List getCustomers() {
		
		return customerService.getAllCustomers();
	}
	
	@GetMapping("/customers/{id}") 
	public Customer getCustomerbyId(@PathVariable(value="id") int id) {
		
		return customerService.getCustomerbyID(id);
	}
//	@GetMapping("/products/{productName}") 
//	public Product getProductbyName(@RequestParam(value="name") String productName) {
//		
//		return productService.getProductbyName(productName);
//	}
//	
	@PostMapping("/addcustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		
		return customerService.addCustomer(customer);
	}
	@PutMapping("/updatecustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		return customerService.updateCustomer(customer);
	}
	@DeleteMapping("/deletecustomer/{id}")
	public AddResponse deleteCustomer(@PathVariable(value="id") int id) {
		
		return customerService.deleteCustomer(id);
	}
	
	}

