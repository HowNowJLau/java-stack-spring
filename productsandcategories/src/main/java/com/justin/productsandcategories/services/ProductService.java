package com.justin.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.justin.productsandcategories.models.Category;
import com.justin.productsandcategories.models.Product;
import com.justin.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository productRepo;
	
	public ProductService(ProductRepository productRepo) {
		this.productRepo = productRepo;
	}
	
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
	public Product getOne(Long id) {
		Optional<Product> optionalProduct = productRepo.findById(id);
		return optionalProduct.isPresent() ? optionalProduct.get() : null;
	}
	
	public List<Product> getAddableProducts(Category category) {
		return productRepo.findByCategoriesNotContains(category);
	}
	
	public Product create(Product product) {
		return productRepo.save(product);
	}
	
	public Product update(Product product) {
		return productRepo.save(product);
	}
	
	public void delete(Long id) {
		productRepo.deleteById(id);
	}

}
