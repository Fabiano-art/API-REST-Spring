package com.soft.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.soft.entity.Category;
import com.soft.entity.Order;
import com.soft.entity.Product;
import com.soft.entity.User;
import com.soft.enums.OrderStatus;
import com.soft.repository.CategoryRepository;
import com.soft.repository.OrderRepository;
import com.soft.repository.ProductRepository;
import com.soft.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository ur;
	
	@Autowired
	private OrderRepository or;
	
	@Autowired
	private CategoryRepository cr;
	
	@Autowired
	private ProductRepository pr;
	
	@Override
	public void run(String... args) throws Exception {
		
		User u1 = new User(null, "Maria Brown", "emailMaria@gmail.com", "956865234", "123456");
		User u2 = new User(null, "Hardwell", "hardwell@gmail.com", "vai são paulo", "654321");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1, OrderStatus.PAID);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2, OrderStatus.WAITING_PAYMENT);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1, OrderStatus.WAITING_PAYMENT);
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers"); 
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p2.getCategories().add(cat2);
		
		ur.save(u1);
		ur.save(u2);
		
		or.saveAll(Arrays.asList(o1, o2, o3));
		
		cr.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		pr.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
	}
	
	
}
