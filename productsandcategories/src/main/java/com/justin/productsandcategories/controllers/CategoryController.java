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

import com.justin.productsandcategories.models.Category;
import com.justin.productsandcategories.services.CategoryAndProductService;
import com.justin.productsandcategories.services.CategoryService;
import com.justin.productsandcategories.services.ProductService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

	private final CategoryService categoryServ;
	private final ProductService productServ;
	private final CategoryAndProductService combinedServ;
	
	public CategoryController(CategoryService categoryServ, ProductService productServ, CategoryAndProductService combinedServ) {
		this.categoryServ = categoryServ;
		this.productServ = productServ;
		this.combinedServ = combinedServ;
	}
	
	@GetMapping("/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/category/new.jsp";
	}

	@PostMapping("/new/process")
	public String processNewCategory(@Valid @ModelAttribute("category") Category category,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/category/new.jsp";
		}
		categoryServ.create(category);
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	public String showCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryServ.getOne(id);
		model.addAttribute("category", category);
		model.addAttribute("addProducts", productServ.getAddableProducts(category));
		return "/category/showOne.jsp";
	}
	
	@PostMapping("/{id}/addProduct")
	public String addProduct(@RequestParam(value="productToAdd") Long productId, @PathVariable("id") Long categoryId) {
		combinedServ.addProduct(categoryId, productId);
		return "redirect:/categories/" + categoryId;
	}
}
