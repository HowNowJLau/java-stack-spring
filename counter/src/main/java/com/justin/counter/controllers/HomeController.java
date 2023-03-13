package com.justin.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class HomeController {
	@RequestMapping("")
	public String index(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		session.setAttribute("count", (Integer) session.getAttribute("count") + 1);
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		return "counter.jsp";
	}
	
	@RequestMapping("/counter/addtwo")
	public String addTwo(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		session.setAttribute("count", (Integer) session.getAttribute("count") + 2);
		return "addTwo.jsp";
	}
	
	@RequestMapping("/counter/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/your_server/counter";
	}
}
