package com.project2.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(value="feignDemo", url="localhost:8081/project1")
public interface Project2Service {

	@GetMapping("/name")
	public String getName();
	
}
