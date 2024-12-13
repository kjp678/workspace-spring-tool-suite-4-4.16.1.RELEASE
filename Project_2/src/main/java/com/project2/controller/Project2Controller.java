package com.project2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.service.Project2Service;

@RestController
@RequestMapping("/project2")
public class Project2Controller {

	@Autowired
	private Project2Service project2Service;
	
	@GetMapping("/user-name")
	public String getUserName() {
		return project2Service.getName();
	}
}
