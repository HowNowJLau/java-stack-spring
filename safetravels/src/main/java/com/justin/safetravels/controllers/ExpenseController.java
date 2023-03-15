package com.justin.safetravels.controllers;

import java.util.List;

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

import com.justin.safetravels.models.Expense;
import com.justin.safetravels.services.ExpenseService;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {

	private final ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping("")
	public String index(Model model) {
		List<Expense> allExpenses = expenseService.getAll();
		model.addAttribute("allExpenses", allExpenses);
		model.addAttribute("expense", new Expense());
		return "index.jsp";
	}
	
	@PostMapping("/process")
	public String newExpense(@Valid @ModelAttribute("expense") Expense expense,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expense> allExpenses = expenseService.getAll();
			model.addAttribute("allExpenses", allExpenses);
			return "index.jsp";
		}
		expenseService.create(expense);
		return "redirect:/expenses";
	}
	
	@GetMapping("/edit/{id}")
	public String editPage(@PathVariable("id") Long id, Model model) {
		Expense expenseToEdit = expenseService.getOne(id);
		model.addAttribute("expense", expenseToEdit);
		return "edit.jsp";
	}
	
	@PutMapping("/edit/{id}/process")
	public String processEdit(@Valid @ModelAttribute("expense") Expense expense, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}
		expenseService.update(expense);
		return "redirect:/expenses";
	}
	
	@DeleteMapping("/delete/{id}")
	public String processDelete(@PathVariable("id") Long id) {
		expenseService.delete(id);
		return "redirect:/expenses";
	}
	
	@GetMapping("/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		Expense expenseToDisplay = expenseService.getOne(id);
		model.addAttribute("expense", expenseToDisplay);
		return "displayOne.jsp";
	}
}
