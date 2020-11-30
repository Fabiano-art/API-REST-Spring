package com.soft.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.soft.entity.User;
import com.soft.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository ur;

	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "emailMaria@gmail.com", "956865234", "123456");
		User u2 = new User(null, "Hardwell", "hardwell@gmail.com", "vai são paulo", "654321");
		
		ur.save(u1);
		
		ur.save(u2);
		
	}
	
	
}
