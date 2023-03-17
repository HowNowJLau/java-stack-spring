package com.justin.loginandregdemo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.justin.loginandregdemo.models.LoginUser;
import com.justin.loginandregdemo.models.User;
import com.justin.loginandregdemo.repositories.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
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
	
	public User login(LoginUser loginUser, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		User user = getOne(loginUser.getEmail());
		if(user == null) {
			result.rejectValue("email", "Unique", "Invalid login credentials");
			return null;
		}
		if(!BCrypt.checkpw(loginUser.getPassword(), user.getPassword())) {
			result.rejectValue("email", "Match", "Invalid login credentials");
			return null;
		}
		return user;
	}
}
