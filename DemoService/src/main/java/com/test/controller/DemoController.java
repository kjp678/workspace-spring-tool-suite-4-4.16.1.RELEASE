package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class DemoController {

	@GetMapping("/name")
	public String getName() {
		return "Patil";
		
	}
	@GetMapping("/address")
	public String getAddress() {
		return "India";
	}
	
	
}
