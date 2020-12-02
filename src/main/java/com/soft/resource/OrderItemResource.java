package com.soft.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soft.entity.OrderItem;
import com.soft.service.OrderItemService;

@RestController
@RequestMapping(value = "/orderItems")
public class OrderItemResource {
	
	@Autowired
	private OrderItemService service;
	
	@GetMapping
	public ResponseEntity<List<OrderItem>> findAll(){
		List<OrderItem> users = service.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderItem> findById(@PathVariable Long id){
		OrderItem obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
