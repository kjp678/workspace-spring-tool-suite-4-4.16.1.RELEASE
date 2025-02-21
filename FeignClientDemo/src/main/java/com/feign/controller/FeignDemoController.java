package com.feign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feign.service.FeignService;

@RestController
@RequestMapping("/demo")
public class FeignDemoController {
	

	@Autowired
	private FeignService feignService;
	
	
	@GetMapping("/userName")
	public String getUserName() {
		
		return feignService.getName();
		
	}
	
	@GetMapping("/userAddress")
	public String getUserAddress() {
		
		return feignService.getAddress();
		
	}
}
