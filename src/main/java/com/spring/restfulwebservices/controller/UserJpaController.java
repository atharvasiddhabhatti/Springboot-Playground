package com.spring.restfulwebservices.controller;

import com.spring.restfulwebservices.Exception.UserNotFoundException;
import com.spring.restfulwebservices.dao.UserDaoService;
import com.spring.restfulwebservices.entity.User;
import com.spring.restfulwebservices.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaController {
	
	@Autowired
	private UserDaoService service;

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retriveUser( @PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(user.isPresent())
			throw new UserNotFoundException("ID:- "+ id);
		return user.get();
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		URI location =  ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/jpa/{id}")
	public void deleteUser( @PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user==null)
			throw new UserNotFoundException("ID:- "+ id);
		
		
	}
	
}
