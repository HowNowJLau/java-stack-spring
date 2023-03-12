package com.justin.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("")
	public String index(@RequestParam(value="name", required=false) String name, 
			@RequestParam(value="lastName", required=false) String lastName,
			@RequestParam(value="times", required=false) Integer times) {
		if (times == null) {
			if (name == null) {
				return "Hello human";
			}
			if (lastName == null) {
				return "Hello " + name;
			}
			return "Hello " + name + " " + lastName;
		}
		else {
			String output = "";
			for (int i = 0; i < times; i++) {
				if (name == null) {
					output += "Hello human";
				}
				else if (lastName == null) {
					output += "Hello " + name;
				}
				else {
					output += "Hello " + name + " " + lastName;
				}
				output += " ";
			}
			return output;
		}
	}

}
