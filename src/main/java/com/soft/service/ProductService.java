package com.soft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.entity.Product;
import com.soft.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository userRep;
	
	public List<Product> findAll(){
		return userRep.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = userRep.findById(id);
		return obj.get();
	}
	
}
