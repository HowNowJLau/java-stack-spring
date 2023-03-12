package com.justin.firstjspdemo.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("someData", "this is some data from the controller");
		return "index.jsp";
	}
	
	@GetMapping("/demo")
	public String demo() {
		return "demo.jsp";
	}
	
	@GetMapping("/jstl/demo")
	public String jstlDemo(Model model) {
		String name = "Ashot";
		Integer age = 23;
		Boolean isMillionaire = true;
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("isMillionaire", isMillionaire);
		model.addAttribute("test", "<script>alert('h1')</script>");
		
		ArrayList<String> users = new ArrayList<String>();
		users.add("Bobby Brown");
		users.add("Jimmy Bean");
		users.add("Martha Smith");
		users.add("Tina Ternary");
		
		model.addAttribute("users", users);
		return "jstl.jsp";
	}
}
