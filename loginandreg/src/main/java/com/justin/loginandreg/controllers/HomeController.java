package com.justin.loginandreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.justin.loginandreg.models.LoginUser;
import com.justin.loginandreg.models.User;
import com.justin.loginandreg.services.BookService;
import com.justin.loginandreg.services.UserService;

@Controller
public class HomeController {
    
     @Autowired
     private UserService userServ;
     
     @Autowired
     private BookService bookServ;
    
    @GetMapping("/")
    public String index(Model model, HttpSession session) {
    	if (session.getAttribute("user_id") != null) {
    		return "redirect:/home";
    	}
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "/user/index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
        // to do some extra validations and create a new user!
    	User userToRegister = userServ.register(newUser, result);
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "/user/index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", userToRegister.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "/user/index.jsp";
        }
    
        // No errors! 
        session.setAttribute("user_id", user.getId());
    
        return "redirect:/home";
    }
    
    @GetMapping("/home")
    public String dashboard(HttpSession session, Model model) {
    	if (session.getAttribute("user_id") == null) {
    		return "redirect:/";
    	}
    	model.addAttribute("loggedUser", userServ.getOne((Long) session.getAttribute("user_id")));
    	model.addAttribute("allBooks", bookServ.getAll());
    	return "/main/dashboard.jsp";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
}