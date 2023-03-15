package com.justin.burgertracker.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.justin.burgertracker.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long> {

}
