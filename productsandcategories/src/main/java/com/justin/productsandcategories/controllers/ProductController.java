package com.justin.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.justin.productsandcategories.models.Product;
import com.justin.productsandcategories.services.CategoryAndProductService;
import com.justin.productsandcategories.services.CategoryService;
import com.justin.productsandcategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private final CategoryService categoryServ;
	private final ProductService productServ;
	private final CategoryAndProductService combinedServ;
	
	public ProductController(CategoryService categoryServ, ProductService productServ,  CategoryAndProductService combinedServ) {
		this.categoryServ = categoryServ;
		this.productServ = productServ;
		this.combinedServ = combinedServ;
	}

	@GetMapping("/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/product/new.jsp";
	}
	
	@PostMapping("/new/process")
	public String processNewProduct(@Valid @ModelAttribute("product") Product product,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/product/new.jsp";
		}
		productServ.create(product);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Product product = productServ.getOne(id);
		model.addAttribute("product", product);
		model.addAttribute("addCategories", categoryServ.getAddableCategories(product));
		return "/product/showOne.jsp";
	}
	
	@PostMapping("/{id}/addCategory") 
	public String addCategory(@RequestParam(value="categoryToAdd") Long categoryId, @PathVariable("id") Long productId) {
		combinedServ.addCategory(categoryId, productId);
		return "redirect:/products/" + productId;
	}
}
