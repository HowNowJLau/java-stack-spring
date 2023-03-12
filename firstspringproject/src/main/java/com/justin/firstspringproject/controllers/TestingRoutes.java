package com.justin.firstspringproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingRoutes {
	@RequestMapping("/api/testing")
	public String testing() {
		return "testing";
	}
	
	@RequestMapping("/api/number")
	public Integer number() {
		return 10;
	}
}
