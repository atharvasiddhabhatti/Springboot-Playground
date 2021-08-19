package com.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootDemoActivemqApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoActivemqApplication.class, args);
		System.out.println("Rabbit MQ Service Running!");
	}

}
