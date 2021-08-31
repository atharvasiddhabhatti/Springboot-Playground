package com.spring.service;

import java.util.List;

import com.spring.model.Product;

public interface ProductService {
	Product createProduct(Product product);
	Product updateProduct(Product product);
	
	List<Product> getAllProducts();
	Product getProductById(Integer productId);
	void deleteProductById(Integer productId);
}
