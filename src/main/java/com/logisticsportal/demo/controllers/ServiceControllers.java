package com.logisticsportal.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/services")
public class ServiceControllers {

	@GetMapping
	public String getServices() {
		
		return "http GET request for all Services was sent";
	}
	@GetMapping(path="/{serviceID}") 
	public String getService(@PathVariable String serviceID) {
		
		return "http GET request was sent for ServiceID: " +serviceID;
	}
//	@GetMapping   //QueryParameter
//	public String getServices(@RequestParam(value="page") int pageno,@RequestParam(value="limit") int limitno) {
//		
//		return "http GET request was sent for page: "+pageno+"and limit is: "+limitno  ;
//	}
	@PostMapping
	public String createService() {
		
		return "http POST request for all Services was sent";
	}
	@PutMapping
	public String updateService() {
		
		return "http PUT request for all Services was sent";
	}
	@DeleteMapping
	public String deleteService() {
		
		return "http DELETE request for all Services was sent";
	}
}
