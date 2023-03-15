package com.justin.mvcdemo.controllers;

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
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.mvcdemo.models.Donation;
import com.justin.mvcdemo.services.DonationService;

@Controller
@RequestMapping("/donations")
public class DonationController {

	private final DonationService donationServ;
	
	public DonationController(DonationService donationServ) {
		this.donationServ = donationServ;
	}
	
	@GetMapping("/all")
	public String getAllDonations(Model model) {
		model.addAttribute("allDonations", donationServ.getAll());
		return "/donation/showAll.jsp";
	}
	
	@GetMapping("/{id}")
	public String getOneDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationServ.getOne(id));
		return "/donation/displayOne.jsp";
	}
	
	@GetMapping("/create")
	public String createDonation(@ModelAttribute("donation") Donation donation) {
		return "/donation/form.jsp";
	}
	
	@PostMapping("/process")
	public String processDonation(@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/donation/form.jsp";
		}
		donationServ.create(donation);
		return "redirect:/donations/" + donation.getId();
	}
	
	@GetMapping("/{id}/edit")
	public String editDonation(@PathVariable("id") Long id, Model model) {
		model.addAttribute("donation", donationServ.getOne(id));
		return "/donation/edit.jsp";
	}
	
	@PutMapping("/process/{id}")
	public String processEditDonation(@Valid @ModelAttribute("donation") Donation donation,
			BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/donation/edit.jsp";
		}
		donationServ.update(id, donation);
		return "redirect:/donations/" + donation.getId();
	}
	
	@DeleteMapping("/{id}/delete")
	public String deleteDonation(@PathVariable("id") Long id) {
		donationServ.delete(id);
		return "redirect:/donations/all";
	}
}
