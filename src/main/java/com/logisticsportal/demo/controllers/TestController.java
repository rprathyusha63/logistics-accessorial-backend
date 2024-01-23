package com.logisticsportal.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value="/lpp")
	public String hello() {
		return "Welcome to Logistics Portal Project!! ";
	}

}
