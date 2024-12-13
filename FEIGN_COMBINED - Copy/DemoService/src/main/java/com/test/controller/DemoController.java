package com.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo") //server.port = 8084
public class DemoController {

	@GetMapping("/name")
	public String getName() {
		return "Kishore";
	}
	@GetMapping("/address")
	public String getAddress() {
		return "Mumbai";
	}

	
}
