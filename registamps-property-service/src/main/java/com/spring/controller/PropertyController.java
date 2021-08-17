package com.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Property;
import com.spring.exception.CustomExceptionHandling;
import com.spring.exception.GlobalExceptionHandler;
import com.spring.service.PropertyService;

@RestController
@RequestMapping(value="/property")
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping(value="/{id}")
	public Optional<Property> findPropertyById(@PathVariable Integer id) {
		Optional<Property> property = Optional.ofNullable(propertyService.findPropertyById(id).orElseThrow(() -> new GlobalExceptionHandler()));
			return property;
			
	}
	@PostMapping(value="/addproperty")
	public Property addProperty(@RequestBody Property property) {
		return propertyService.addProperty(property);
	}
	@PatchMapping(value="/addproperty")
	public Property updateProperty(@RequestBody Property property) {
		return propertyService.addProperty(property);
	}
	@GetMapping("/getpropertybystatus")
	public List<Property> findPropertyByStatus(@RequestParam String status) {
		List<Property> property = propertyService.findPropertyByStatus(status);
		if(property.isEmpty())
			throw new GlobalExceptionHandler();
		
		return property;
	}
}
// DWZPS3196F