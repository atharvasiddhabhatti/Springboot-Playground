package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.spring.repository.ProductRepository;

@SpringBootApplication
public class SpringbootDemoMongodbCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoMongodbCrudApplication.class, args);
	}

}
