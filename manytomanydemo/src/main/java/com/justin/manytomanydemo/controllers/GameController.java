package com.justin.manytomanydemo.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.manytomanydemo.models.Game;
import com.justin.manytomanydemo.services.GameService;
import com.justin.manytomanydemo.services.GenreService;

@Controller
@RequestMapping("/games")
public class GameController {

	private final GameService gameServ;
	public GameController(GameService gameServ) {
		this.gameServ = gameServ;
	}

	@PostMapping("/process")
	public String processCreateGame(@Valid @ModelAttribute("game") Game game,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("allGames", gameServ.getAll());
			return "/main/dashboard.jsp";
		}
		gameServ.createGameWithGenre(game);
		return "redirect:/";
	}
}
