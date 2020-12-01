package com.soft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.entity.Category;
import com.soft.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository userRep;
	
	public List<Category> findAll(){
		return userRep.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = userRep.findById(id);
		return obj.get();
	}
	
}
