package com.justin.mvcdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.mvcdemo.models.Donation;
import com.justin.mvcdemo.repositories.DonationRepository;

@Service
public class DonationService {

	private final DonationRepository donationRepo;
	public DonationService(DonationRepository donationRepo) {
		this.donationRepo = donationRepo;
	}
	
	public List<Donation> getAll() {
		return (List<Donation>) donationRepo.findAll();
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
	
	public Donation update(Long id, String donationName, String donor, Integer quantity) {
		if (donationRepo.existsById(id)) {
			Donation donationToUpdate = new Donation(id, donationName, donor, quantity);
			return donationRepo.save(donationToUpdate);
		}
		return null;
	}
	
	public void delete(Long id) {
		donationRepo.deleteById(id);
	}
}
