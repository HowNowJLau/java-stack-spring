package com.justin.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.justin.dojosandninjas.models.Dojo;
import com.justin.dojosandninjas.models.Ninja;
import com.justin.dojosandninjas.services.DojoService;
import com.justin.dojosandninjas.services.NinjaService;

@Controller
public class HomeController {
	
	private final DojoService dojoServ;
	private final NinjaService ninjaServ;
	
	public HomeController(DojoService dojoServ, NinjaService ninjaServ) {
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allDojos", dojoServ.getAll());
		return "/main/dashboard.jsp";
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		model.addAttribute("dojo", dojoServ.getOne(id));
		return "/dojo/showOne.jsp";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("newDojo") Dojo newDojo) {
		return "/dojo/new.jsp";
	}
	
	@PostMapping("/dojos/process")
		public String processDojo(@Valid @ModelAttribute("newDojo") Dojo newDojo, 
				BindingResult result) {
		if (result.hasErrors()) {
			return "/dojo/new.jsp";
		}
		dojoServ.create(newDojo);
		return "redirect:/";
	}
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("newNinja") Ninja newNinja, Model model) {
		model.addAttribute("allDojos", dojoServ.getAll());
		return "/ninja/new.jsp";
	}

	@PostMapping("/ninjas/process")
	public String processNinja(@Valid @ModelAttribute("newNinja") Ninja newNinja,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allDojos", dojoServ.getAll());
			return "/ninja/new.jsp";
		}
		ninjaServ.create(newNinja);
		return "redirect:/";
	}
}
