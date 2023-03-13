package com.justin.sessionformdemo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@GetMapping("/home")
	public String setCount(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		return "/sessionDemo/counterPage.jsp";
	}
	
	@GetMapping("/get/count")
	public String getCount() {
		return "sessionDemo/getCount.jsp";
	}
	
	@GetMapping("/search")
	public String searchForm() {
		return "getForm/form.jsp";
	}
	
	@GetMapping("/search/display")
	public String displayForm(@RequestParam("keyword") String keyword, Model model) {
		model.addAttribute("keyword", keyword);
		return "getForm/display.jsp";
	}
	
	@GetMapping("/review/form")
	public String renderReviewForm() {
		return "postForm/form.jsp";
	}
	
	@PostMapping("/process/review/form")
	public String processReviewForm(@RequestParam("movie") String movie,
			@RequestParam("comment") String comment, 
			@RequestParam("rating") Integer rating, HttpSession session) {
		session.setAttribute("movie", movie);
		session.setAttribute("comment", comment);
		session.setAttribute("rating", rating);
		return "redirect:/display/review/form";
	}
	
	@GetMapping("/display/review/form")
	public String displayReviewForm() {
		return "postForm/display.jsp";
	}
}
