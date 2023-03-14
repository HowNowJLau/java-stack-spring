package com.justin.booksapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.booksapi.models.Book;
import com.justin.booksapi.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Book oneBook = bookService.findBook(id);
		model.addAttribute("book", oneBook);
		return "show.jsp";
	}

}
