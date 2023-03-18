package com.justin.loginandreg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.loginandreg.models.Book;
import com.justin.loginandreg.repositories.BookRepository;

@Service
public class BookService {
	
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}

	public List<Book> getAll() {
		return bookRepo.findAll();
	}
	
	public Book getOne(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		return optionalBook.isPresent() ? optionalBook.get() : null;
	}
	
	public Book create(Book book) {
		return bookRepo.save(book);
	}
	
	public Book update(Book book) {
		return bookRepo.save(book);
	}
	
	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
