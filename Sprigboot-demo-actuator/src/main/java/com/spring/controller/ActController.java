package com.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActController {
	@GetMapping("/info")
	public String getMessage() {
		return "This is the actuator to check the health of the APIs";
	}
}
