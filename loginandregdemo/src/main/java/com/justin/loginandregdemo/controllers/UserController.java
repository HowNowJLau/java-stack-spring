package com.justin.loginandregdemo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.loginandregdemo.models.LoginUser;
import com.justin.loginandregdemo.models.User;
import com.justin.loginandregdemo.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userServ;
	public UserController( UserService userServ) {
		this.userServ = userServ;
	}

	@GetMapping("/login/reg")
	public String loginReg(@ModelAttribute("newUser") User user,
			@ModelAttribute("loginUser") LoginUser loginUser, HttpSession session) {
		if (session.getAttribute("user_id") != null) {
			return "redirect:/";
		}
		return "/user/loginReg.jsp";
	}
	
	@PostMapping("/process/register")
	public String processRegister(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model, HttpSession session) {
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "Match", "Passwords must match");
		}
		
		if (userServ.getOne(newUser.getEmail()) != null) {
			result.rejectValue("email", "Unique", "A user has already been registered with this email");
		}
		
		if (result.hasErrors()) {
			model.addAttribute("loginUser", new LoginUser());
			return "/user/loginReg.jsp";
		}
		User newlyCreatedUser = userServ.registerUser(newUser);
		session.setAttribute("user_id", newlyCreatedUser.getId());
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String processLogin(@Valid @ModelAttribute("loginUser") LoginUser loginUser, 
			BindingResult result, Model model, HttpSession session) {
		User loggingUser = userServ.login(loginUser, result);
		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "/user/loginReg.jsp";
		}
		session.setAttribute("user_id", loggingUser.getId());
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/users/login/reg";
	}
}
