package com.justin.mvc2onetomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.mvc2onetomany.models.User;
import com.justin.mvc2onetomany.repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepo;
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public List<User> getAll() {
		return userRepo.findAll();
	}
	
	public User create(User user) {
		return userRepo.save(user);
	}
	
	public User getOne(Long id) {
		Optional<User> optionalUser = userRepo.findById(id);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}
	
	public User getOne(String email) {
		Optional<User> optionalUser = userRepo.findByEmail(email);
		return optionalUser.isPresent() ? optionalUser.get() : null;
	}
}
