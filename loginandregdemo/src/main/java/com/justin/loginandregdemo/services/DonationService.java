package com.justin.loginandregdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.loginandregdemo.models.Donation;
import com.justin.loginandregdemo.repositories.DonationRepository;

@Service
public class DonationService {

	private final DonationRepository donationRepo;
	public DonationService(DonationRepository donationRepo) {
		this.donationRepo = donationRepo;
	}
	
	public List<Donation> getAll() {
		return donationRepo.findAll();
	}

	public Donation create(Donation donation) {
		return donationRepo.save(donation);
	}
	
	public Donation getOne(Long id) {
		Optional<Donation> optionalDonation = donationRepo.findById(id);
		if (optionalDonation.isPresent()) {
			return optionalDonation.get();
		}
		return null;
	}
	
	public Donation update(Donation donation) {
		return donationRepo.save(donation);
	}
	
	public void delete(Long id) {
		donationRepo.deleteById(id);
	}

}
