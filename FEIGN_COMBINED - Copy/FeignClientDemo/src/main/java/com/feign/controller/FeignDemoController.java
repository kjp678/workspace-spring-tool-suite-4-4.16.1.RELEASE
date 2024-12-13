package com.feign.controller;

import com.feign.service.FeignService;
import com.feign.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/feign") //8086
public class FeignDemoController {
	

	@Autowired
	private FeignService feignService;

	@Autowired
	private ServiceImpl serviceImpl;
	
	@GetMapping("/userName")
	public String getUserName() {
		
		return feignService.getName();
		
	}
	
	@GetMapping("/userAddress")
	public String getUserAddress() {

		return feignService.getAddress();
		
	}

	@GetMapping("/name/webClient")
	public String getNameWebClient(){

		return serviceImpl.getName();
	}
}
