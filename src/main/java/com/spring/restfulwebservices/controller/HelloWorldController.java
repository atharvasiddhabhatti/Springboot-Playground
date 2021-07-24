package com.spring.restfulwebservices.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spring.restfulwebservices.bean.HelloWorldBean;

@RestController
public class HelloWorldController {
	
	@GetMapping(value="/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@GetMapping(value="/hello-world-bean")
	public HelloWorldBean HelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//http://localhost:8080//hello-world/path-variable/Atharva
	@GetMapping(value="/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldBean(@PathVariable String name) {
		return new HelloWorldBean("Hello World "+name);
	}
	
}
