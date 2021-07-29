package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootHelloWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootHelloWorldApplication.class, args);
		 System.out.println("Application is Running....");
	}

}
