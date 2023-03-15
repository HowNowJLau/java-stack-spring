package com.justin.safetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.safetravels.models.Expense;
import com.justin.safetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepository;
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public List<Expense> getAll() {
		return (List<Expense>)expenseRepository.findAll();
	}
	
	public Expense getOne(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if (optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		return null;
	}
	
	public Expense create(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public Expense update(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public void delete(Long id) {
		expenseRepository.deleteById(id);
	}
}
