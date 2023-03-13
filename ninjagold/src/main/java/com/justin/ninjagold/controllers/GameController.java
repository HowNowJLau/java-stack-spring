package com.justin.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GameController {
	private ArrayList<String> activities = new ArrayList<String>();
	
	@RequestMapping("")
	public String game(HttpSession session) {
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			activities.clear();
		}
		
		return "game.jsp";
	}
	
	@RequestMapping(value="/find/gold", method=RequestMethod.POST)
	public String find(@RequestParam("location") String location, 
			HttpSession session, RedirectAttributes redirectAttributes) {
		Random rand = new Random();
		Integer reward = 0;
		String output = "";
		Date date = new Date();
		if (location.equals("farm")) {
			reward = rand.nextInt(11) + 10;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + reward);
			output = "<p style='color:green'>You entered a " + location + " and earned " + reward + " gold. (" + date + ")</p>";
		}
		if (location.equals("cave")) {
			reward = rand.nextInt(6) + 5;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + reward);
			output = "<p style='color:green'>You entered a " + location + " and earned " + reward + " gold. (" + date + ")</p>";
		}
		if (location.equals("house")) {
			reward = rand.nextInt(4) + 2;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + reward);
			output = "<p style='color:green'>You entered a " + location + " and earned " + reward + " gold. (" + date + ")</p>";
		}
		if (location.equals("quest")) {
			reward = rand.nextInt(101) - 50;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + reward);
			if (reward < 0) {
				output = "<p style='color:red'>You failed a quest and lost " + reward * -1 + " gold. Ouch. (" + date + ")</p>";
			}
			else {
				output = "<p style='color:green'>You completed a quest and earned " + reward + " gold. (" + date + ")</p>";
			}
		}
		session.setAttribute("test", "<p>Hello</p>");
		System.out.println(output);
		activities.add(output);
		session.setAttribute("activities", activities);
		return "redirect:/";
	}
	
}
