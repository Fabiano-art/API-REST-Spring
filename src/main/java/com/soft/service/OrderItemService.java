package com.soft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.entity.OrderItem;
import com.soft.repository.OrderItemRepository;

@Service
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository userRep;
	
	public List<OrderItem> findAll(){
		return userRep.findAll();
	}
	
	public OrderItem findById(Long id) {
		Optional<OrderItem> obj = userRep.findById(id);
		return obj.get();
	}
	
}
