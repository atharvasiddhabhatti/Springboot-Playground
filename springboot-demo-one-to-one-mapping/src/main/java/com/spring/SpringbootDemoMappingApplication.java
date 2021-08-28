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
	

	public static void main(String[] args)  {
		SpringApplication.run(SpringbootDemoMappingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer();
		customer.setName("Atharva Siddhabhatti");
		customer.setEmail("atharvasiddhabhatti@gmail.com");
		Item item = new Item();
		item.setName("Macbook");
		item.setQty(1);
		customer.setItem(item);
		item.setCustomer(customer);
		customerRepository.save(customer);
		

		
		
	}

}
