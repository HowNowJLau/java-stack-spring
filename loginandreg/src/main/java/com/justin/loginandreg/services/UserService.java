package com.justin.loginandreg.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.justin.loginandreg.models.LoginUser;
import com.justin.loginandreg.models.User;
import com.justin.loginandreg.repositories.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepo;
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	public User create(User user) {
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
	
	public User register(User newUser, BindingResult result) {
	    
    	// TO-DO - Reject values or register if no errors:

        // Reject if email is taken (present in database)
		if (userRepo.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue("email", "Unique", "A user has already been created with this email");
		}
        // Reject if password doesn't match confirmation
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("password", "Match", "Passwords do not match");
        }
        // Return null if result has errors
        if (result.hasErrors()) {
        	return null;
        }
        // Hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
    }
	
	// This method will be called from the controller
    // whenever a user submits a login form.
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO - Reject values:
    	if (result.hasErrors()) {
    		return null;
    	}
    	// Find user in the DB by email
    	Optional<User> potentialLogin = userRepo.findByEmail(newLoginObject.getEmail());
        // Reject if NOT present
    	if (!potentialLogin.isPresent()) {
        	result.rejectValue("email", "Bad Login", "Invalid credentials");
        }
        
        // Reject if BCrypt password match fails
    	else if (!BCrypt.checkpw(newLoginObject.getPassword(), potentialLogin.get().getPassword())) {
    		result.rejectValue("email", "Bad Login", "Invalid credentials");
    	}
    	
        // Return null if result has errors
    	if (result.hasErrors()) {
    		return null;
    	}
        return potentialLogin.get();
    }
    
}
