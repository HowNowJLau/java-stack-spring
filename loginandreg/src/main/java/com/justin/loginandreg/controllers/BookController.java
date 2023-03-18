package com.justin.loginandreg.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.justin.loginandreg.models.Book;
import com.justin.loginandreg.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	private final BookService bookServ;
	
	public BookController(BookService bookServ) {
		this.bookServ = bookServ;
	}

	@GetMapping("/create")
	public String createForm(@ModelAttribute("book") Book book) {
		return "/book/create.jsp";
	}
	
	@PostMapping("/process")
	public String processCreate(@Valid @ModelAttribute("book") Book book,
			BindingResult result) {
		if (result.hasErrors()) {
			return "/book/create.jsp";
		}
		bookServ.create(book);
		return "redirect:/home";
	}
	
	@GetMapping("/{id}/view") 
	public String viewOne(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookServ.getOne(id));
		return "/book/viewOne.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("book", bookServ.getOne(id));
		return "/book/edit.jsp";
	}
	
	@PutMapping("/{id}/process")
	public String processEdit(@Valid @ModelAttribute("book") Book book,
			BindingResult result, @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "/book/edit.jsp";
		}
		bookServ.update(book);
		return "redirect:/books/" + id + "/view";
	}
	
	@DeleteMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		bookServ.delete(id);
		return "redirect:/home";
	}
}
