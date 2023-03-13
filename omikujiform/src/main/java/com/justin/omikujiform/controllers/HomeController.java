package com.justin.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class HomeController {
	@RequestMapping("")
	public String form() {
		return "form.jsp";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String process(@RequestParam("number") Integer number, @RequestParam("city") String city, 
			@RequestParam("name") String name, @RequestParam("endeavor") String endeavor,
			@RequestParam("livingThing") String livingThing, @RequestParam("niceMessage") String niceMessage, 
			HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("endeavor", endeavor);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("niceMessage", niceMessage);
		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/show")
	public String display() {
		return "display.jsp";
	}
}
