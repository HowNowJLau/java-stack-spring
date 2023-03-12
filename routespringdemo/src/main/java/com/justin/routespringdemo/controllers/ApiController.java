package com.justin.routespringdemo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

	@RequestMapping("/option/1")
	public String option1() {
		return "option 1 request mapping";
	}

	@RequestMapping(value="/option/2", method=RequestMethod.GET)
	public String option2() {
		return "option 2 request mapping";
	}
	
	@GetMapping("/option/3")
	public String option3() {
		return "option 3 request mapping";
	}
	
	@RequestMapping("/search")
	public String searchKeyword(@RequestParam("keyword") String keywordInMethod) {
		return "You are searching for " + keywordInMethod;
	}
	
	@RequestMapping("/pet")
	public String getPet(@RequestParam("name") String petName, @RequestParam("age") Integer age) {
		return "Your pet " + petName + " is " + age;
	}
	
	@RequestMapping("/optional/pet")
	public String getPetOptional(@RequestParam(value="name", required=false) String petName) {
		return "Your pet name is " + petName;
	}
	
	@RequestMapping("/path/m/{name}/{color}")
	public String petWithColor(@PathVariable("name") String petName, @PathVariable("color") String color) {
		return petName + " is " + color;
	}
}
