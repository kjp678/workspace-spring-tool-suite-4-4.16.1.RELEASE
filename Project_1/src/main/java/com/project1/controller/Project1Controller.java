package com.project1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project1")
public class Project1Controller {

	@GetMapping("/name")
	public String getName() {
		return "Karan";
	}
}
