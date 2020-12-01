package com.soft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.entity.Order;
import com.soft.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRep;

	public List<Order> findAll() {
		return orderRep.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = orderRep.findById(id);
		return obj.get();
	}

}
