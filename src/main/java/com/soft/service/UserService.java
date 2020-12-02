package com.soft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soft.entity.User;
import com.soft.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRep;
	
	public List<User> findAll(){
		return userRep.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRep.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return userRep.save(obj);
	}
	
	public void delete(Long id) {
		userRep.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User entity = userRep.getOne(id);
		updateData(entity, user);
		return userRep.save(entity);
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
		
	}
}
