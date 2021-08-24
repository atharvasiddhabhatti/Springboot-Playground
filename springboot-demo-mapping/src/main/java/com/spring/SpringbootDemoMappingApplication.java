package com.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.entity.Customer;
import com.spring.entity.Item;
import com.spring.repository.CustomerRepository;
import com.spring.repository.ItemRepository;

@SpringBootApplication
public class SpringbootDemoMappingApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ItemRepository itemRepository;

	public static void main(String[] args)  {
		SpringApplication.run(SpringbootDemoMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer("John");
		Item item1 = new Item("Item1");
		customer.setItem(item1);
		customerRepository.save(customer);
		
		
		
	}

}
