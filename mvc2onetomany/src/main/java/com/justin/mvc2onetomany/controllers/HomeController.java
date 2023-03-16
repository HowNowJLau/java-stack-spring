package com.justin.mvc2onetomany.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.justin.mvc2onetomany.models.Donation;
import com.justin.mvc2onetomany.models.User;
import com.justin.mvc2onetomany.services.DonationService;
import com.justin.mvc2onetomany.services.UserService;

@Controller
public class HomeController {

	private final UserService userServ;
	private final DonationService donationServ;
	
	public HomeController(UserService userServ, DonationService donationServ) {
		this.userServ = userServ;
		this.donationServ = donationServ;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("allDonations", donationServ.getAll());
		model.addAttribute("allUsers", userServ.getAll());
		return "/main/dashboard.jsp";
	}
	
	@GetMapping("/user/create")
	public String createUser(@ModelAttribute("newUser") User user) {
		return"/user/create.jsp";
	}
	
	@PostMapping("/user/process/new")
	public String processNewUser(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result) {
		if (result.hasErrors()) {
			return "/user/create.jsp";
		}
		userServ.create(newUser);
		return "redirect:/";
	}
	
	@GetMapping("/user/{id}")
	public String showOneUser (@PathVariable("id") Long id, Model model) {
		model.addAttribute("user", userServ.getOne(id));
		return "/user/showOne.jsp";
	}
	
	@GetMapping("/donations/create")
	public String createDonation(@ModelAttribute("newDonation") Donation donation, Model model) {
		model.addAttribute("allUsers", userServ.getAll());
		return "/donation/create.jsp";
	}
	
	@PostMapping("/donations/process/new")
	public String processNewDonation(@Valid @ModelAttribute("newDonation") Donation newDonation,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allUsers", userServ.getAll());
			return "/donation/create.jsp";
		}
		donationServ.create(newDonation);
		return "redirect:/";
	}
	
	@GetMapping("/donations/{id}/edit")
	public String editDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationServ.getOne(id));
		return "donation/edit.jsp";
	}
	
	@PutMapping("/donations/{id}/process") 
	public String processEditDonation(@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result) {
		if (result.hasErrors()) {
			return "donation/edit.jsp";
		}
		donationServ.update(donation);
		return "redirect:/";
	}
	
	@DeleteMapping("/donations/{id}/delete")
	public String deleteDonation(@PathVariable("id") Long id) {
		donationServ.delete(id);
		return "redirect:/";
	}
}
