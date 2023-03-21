package com.justin.manytomanydemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.manytomanydemo.models.Game;
import com.justin.manytomanydemo.models.Genre;
import com.justin.manytomanydemo.repositories.GameRepository;
import com.justin.manytomanydemo.repositories.GenreRepository;

@Service
public class GameService {

	private final GameRepository gameRepo;
	private final GenreRepository genreRepo;
	
	public GameService(GameRepository gameRepo, GenreRepository genreRepo) {
		this.gameRepo = gameRepo;
		this.genreRepo = genreRepo;
	}

	public Genre getOneGenre(String genreName) {
		Optional<Genre> optionalGenre = genreRepo.findByName(genreName);
		return optionalGenre.isPresent() ? optionalGenre.get() : null;
	}
	
	public Genre createGenreIfNotInDatabase(String genreName) {
		if (getOneGenre(genreName) == null) {
			Genre newGenre = new Genre();
			newGenre.setName(genreName);
			return genreRepo.save(newGenre);
		}
		return getOneGenre(genreName);
	}
	
	public Game createGameWithGenre(Game game) {
		String[] genresFromForm = game.getGenresFromForm().split(",");
		ArrayList<Genre> genresToBeAdded = new ArrayList<Genre>();
		for (String genre : genresFromForm) {
			genresToBeAdded.add(createGenreIfNotInDatabase(genre));
		}
		game.setGenres(genresToBeAdded);
		return gameRepo.save(game);
	}
	
	public List<Game> getAll() {
		return gameRepo.findAll();
	}
	
	public Game getOne(Long id) {
		Optional<Game> optionalGame = gameRepo.findById(id);
		return optionalGame.isPresent() ? optionalGame.get() : null;
	}
	
	public Game create(Game game) {
		return gameRepo.save(game);
	}
	
	public Game update(Game game) {
		return gameRepo.save(game);
	}
	
	public void delete(Long id) {
		gameRepo.deleteById(id);
	}
}
