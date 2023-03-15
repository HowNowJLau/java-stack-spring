package com.justin.safetravels.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.safetravels.models.Expense;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Long>{

}
