package com.justin.productsandcategories.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.justin.productsandcategories.services.CategoryService;
import com.justin.productsandcategories.services.ProductService;

@Controller
public class HomeController {

	private final CategoryService categoryServ;
	private final ProductService productServ;
	
	public HomeController(CategoryService categoryServ, ProductService productServ) {
		this.categoryServ = categoryServ;
		this.productServ = productServ;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("allProducts", productServ.getAll());
		model.addAttribute("allCategories", categoryServ.getAll());
		return "/main/home.jsp";
	}
}
