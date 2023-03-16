package com.justin.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.dojosandninjas.models.Ninja;
import com.justin.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {

	private final NinjaRepository ninjaRepo;
	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
	public List<Ninja> getAll() {
		return (List<Ninja>) ninjaRepo.findAll();
	}
	
	public Ninja getOne(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		return optionalNinja.isPresent() ? optionalNinja.get() : null;
	}

	public Ninja create(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
