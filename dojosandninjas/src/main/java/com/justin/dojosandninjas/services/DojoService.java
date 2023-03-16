package com.justin.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.dojosandninjas.models.Dojo;
import com.justin.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepo;
	
	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	public List<Dojo> getAll() {
		return (List<Dojo>) dojoRepo.findAll();
	}
	
	public Dojo getOne(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		return optionalDojo.isPresent() ? optionalDojo.get() : null;
	}

	public Dojo create(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
