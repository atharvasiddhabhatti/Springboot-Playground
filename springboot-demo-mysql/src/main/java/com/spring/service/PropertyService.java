package com.spring.service;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.entity.Property;
import com.spring.repository.PropertyRepository;

@Service
public class PropertyService {

	@Autowired
	private PropertyRepository propertyRepository;
	
	public List<Property> retriveAllProperties() {
		return propertyRepository.findAll();
	}
	
	public ResponseEntity<Object> addProperty(Property property) {
	     Property savedProperty = propertyRepository.save(property);
	     URI location =  ServletUriComponentsBuilder
	     .fromCurrentRequest()
	     .path("/{id}")
	     .buildAndExpand(savedProperty.getId()).toUri();
	     return ResponseEntity.created(location).build();
	  }
	
	public Optional<Property> getPropertyById(Integer id) {
		
		return propertyRepository.findById(id);
	}
	
	public String deletePropertyById(Integer id) {
		propertyRepository.deleteById(id);
		return "Successfully Deleted property with ID:- " + id;
	}
	
	public ResponseEntity<Object> updateProperty(Property property) {
	     Property savedProperty = propertyRepository.save(property);
	     URI location =  ServletUriComponentsBuilder
	     .fromCurrentRequest()
	     .path("/{id}")
	     .buildAndExpand(savedProperty.getId()).toUri();
	     return ResponseEntity.created(location).build();
	  }
}
