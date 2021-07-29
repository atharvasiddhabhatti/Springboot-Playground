package com.spring.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.spring.entity.Property;
import com.spring.service.PropertyService;

@RestController
public class PropertyController {
	
	@Autowired
	private PropertyService propertyService;
	
	@GetMapping("/property")
	public List<Property> retriveAllProperties() {
		return propertyService.retriveAllProperties();
	}
	
	@PostMapping("/property")
	public ResponseEntity<Object> addProperty(@RequestBody Property property) {
	     return propertyService.addProperty(property);
	  }
}
