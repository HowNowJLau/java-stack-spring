package com.justin.manytomanydemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.manytomanydemo.models.Genre;
import com.justin.manytomanydemo.repositories.GenreRepository;

@Service
public class GenreService {

	private final GenreRepository genreRepo;
	
	public GenreService(GenreRepository genreRepo) {
		this.genreRepo = genreRepo;
	}

	public List<Genre> getAll() {
		return genreRepo.findAll();
	}
	
	public Genre getOne(Long id) {
		Optional<Genre> optionalGenre = genreRepo.findById(id);
		return optionalGenre.isPresent() ? optionalGenre.get() : null;
	}
	
	public Genre create(Genre genre) {
		return genreRepo.save(genre);
	}
	
	public Genre update(Genre genre) {
		return genreRepo.save(genre);
	}
	
	public void delete(Long id) {
		genreRepo.deleteById(id);
	}
}
