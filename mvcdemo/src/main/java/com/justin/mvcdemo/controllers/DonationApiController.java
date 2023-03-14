package com.justin.mvcdemo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.justin.mvcdemo.models.Donation;
import com.justin.mvcdemo.services.DonationService;

@RestController
@RequestMapping("/api")
public class DonationApiController {
	public final DonationService donationServ;
	
	public DonationApiController(DonationService donationServ) {
		this.donationServ = donationServ;
	}
	
	@GetMapping("/donations")
	public List<Donation> findAllDonations() {
		return donationServ.getAll();
	}
	
	@PostMapping("/donations")
	public Donation createDonation(@RequestParam("donationName") String donationName,
			@RequestParam("donor") String donor, @RequestParam("quantity") Integer quantity) {
		Donation donation = new Donation(donationName, donor, quantity);
		return donationServ.create(donation);
	}
	
	@GetMapping("/donations/{id}")
	public Donation findDonation(@PathVariable("id") Long id) {
		return donationServ.getOne(id);
	}
	
	@PutMapping("/donations/{id}")
	public Donation editOneDonation(@PathVariable("id") Long id, 
			@RequestParam("donationName") String donationName, @RequestParam("donor") String donor, 
			@RequestParam("quantity") Integer quantity) {
		return donationServ.update(id, donationName, donor, quantity);
	}
	
	@DeleteMapping("/donations/{id}")
	public void deleteDonation(@PathVariable("id") Long id) {
		donationServ.delete(id);
	}
}
