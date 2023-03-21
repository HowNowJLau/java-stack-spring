package com.justin.productsandcategories.services;

import org.springframework.stereotype.Service;

import com.justin.productsandcategories.models.Category;
import com.justin.productsandcategories.models.Product;

@Service
public class CategoryAndProductService {

	private final CategoryService categoryServ;
	private final ProductService productServ;
	
	public CategoryAndProductService(CategoryService categoryServ, ProductService productServ) {
		this.categoryServ = categoryServ;
		this.productServ = productServ;
	}

	public Product addCategory(Long categoryId, Long productId) {
		// retrieve an instance of a category using another method in the service.
	    Category thisCategory = categoryServ.getOne(categoryId);
	    
	    // retrieve an instance of a product using another method in the service.
	    Product thisProduct = productServ.getOne(productId);
	    
	    // add the category to this products's list of categories
	    thisProduct.getCategories().add(thisCategory);	
	    
	    // Save thisProduct, since you made changes to its category list.
	    return productServ.update(thisProduct);	
	}
	
	public Category addProduct(Long categoryId, Long productId) {
		// retrieve an instance of a category using another method in the service.
	    Category thisCategory = categoryServ.getOne(categoryId);
	    
	    // retrieve an instance of a product using another method in the service.
	    Product thisProduct = productServ.getOne(productId);
	    
	    // add the product to this category's list of products
	    thisCategory.getProducts().add(thisProduct);
	    
	    // Save thisCategory, since you made changes to its product list.
	    return categoryServ.update(thisCategory);	
	}
}
