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
import com.spring.service.PropertyService;

@RestController
@RequestMapping(value="/property")
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping(value="/{id}")
	public Optional<Property> findPropertyById(@PathVariable Integer id) {
		return propertyService.findPropertyById(id);
	}
	@PostMapping(value="/addproperty")
	public Property addProperty(@RequestBody Property property) {
		return propertyService.addProperty(property);
	}
	@PatchMapping(value="/addproperty")
	public Property updateProperty(@RequestBody Property property) {
		return propertyService.addProperty(property);
	}
	@GetMapping("/getpropertybyid")
	public List<Property> findPropertyByStatus(@RequestParam String status) {
		return propertyService.findPropertyByStatus(status);
	}
}
// DWZPS3196F