package com.justin.burgertracker.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.justin.burgertracker.models.Burger;
import com.justin.burgertracker.services.BurgerService;

@Controller
public class BurgerController {

	private final BurgerService burgerService;
	
	public BurgerController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}
	
	@GetMapping("")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {
		List<Burger> burgerList = burgerService.getAll();
		model.addAttribute("burgers", burgerList);
		return "index.jsp";
	}

	@PostMapping("/process")
	public String processNewBurger (@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Burger> burgerList = burgerService.getAll();
			model.addAttribute("burgers", burgerList);
			return "index.jsp";
		}
		burgerService.create(burger);
		return "redirect:/";
	}
	
}
