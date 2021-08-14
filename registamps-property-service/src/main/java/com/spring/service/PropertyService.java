package com.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Property;
import com.spring.repository.PropertyRepository;

@Service
public class PropertyService {
	
	@Autowired
	PropertyRepository propertyRepository;
	
	
	public List<Property> getAllProperties() {
		
		return propertyRepository.findAll();
	}
	
	public Optional<Property> findPropertyById(Integer id) {
		return propertyRepository.findById(id);
	}
	
	public Property addProperty(Property property) {
		return propertyRepository.save(property);
	}
	
	public Property updateProperty(Property property) {
		return propertyRepository.save(property);
	}
	public List<Property> findPropertyByStatus(String status) {
		return propertyRepository.findByStatus(status);
	}
}
