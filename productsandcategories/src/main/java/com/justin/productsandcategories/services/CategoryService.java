package com.justin.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.productsandcategories.models.Category;
import com.justin.productsandcategories.models.Product;
import com.justin.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepo;
	
	public CategoryService(CategoryRepository categoryRepo) {
		this.categoryRepo = categoryRepo;
	}

	public List<Category> getAll() {
		return categoryRepo.findAll();
	}
	
	public Category getOne(Long id) {
		Optional<Category> optionalCategory = categoryRepo.findById(id);
		return optionalCategory.isPresent() ? optionalCategory.get() : null;
	}
	
	public List<Category> getAddableCategories(Product product) {
		return categoryRepo.findByProductsNotContains(product);
	}
	
	public Category create(Category category) {
		return categoryRepo.save(category);
	}
	
	public Category update(Category category) {
		return categoryRepo.save(category);
	}
	
	public void delete(Long id) {
		categoryRepo.deleteById(id);
	}
	
}
