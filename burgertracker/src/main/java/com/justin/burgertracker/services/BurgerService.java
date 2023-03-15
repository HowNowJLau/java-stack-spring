package com.justin.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.burgertracker.models.Burger;
import com.justin.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {

	private final BurgerRepository burgerRepository;
	
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	public List<Burger> getAll() {
		return (List<Burger>) burgerRepository.findAll();
	}
	
	public Burger create(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public Burger getOne(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if (optionalBurger.isPresent()) {
			return optionalBurger.get();
		}
		return null;
	}

	public Burger update(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public void delete(Long id) {
		burgerRepository.deleteById(id);
	}
}
