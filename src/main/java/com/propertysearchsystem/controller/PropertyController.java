package com.propertysearchsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.propertysearchsystem.dto.PropertyInfo;
import com.propertysearchsystem.model.PropertyDetails;
import com.propertysearchsystem.service.PropertyService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@GetMapping("/")
	public String firstPage() {
		return "Hello World";
	}

	@PostMapping("/add")
	public ResponseEntity<PropertyDetails> addProperty(@RequestBody PropertyDetails propertyDetails) {
		return new ResponseEntity<PropertyDetails>(propertyService.addProperty(propertyDetails), HttpStatus.CREATED);
	}

	public ResponseEntity<?> searchProperty(@RequestBody PropertyInfo propertyInfo) {
		PropertyInfo property = new PropertyInfo();

		return null;
	}
}
