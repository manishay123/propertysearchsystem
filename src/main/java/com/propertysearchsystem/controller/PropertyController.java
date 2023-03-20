package com.propertysearchsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.propertysearchsystem.dto.PropertyInfo;
import com.propertysearchsystem.model.PropertyDetails;
import com.propertysearchsystem.service.PropertyService;

import java.util.List;

@RestController
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PostMapping("/property")
	public ResponseEntity<PropertyDetails> addProperty(@RequestBody PropertyDetails propertyDetails) {
		return new ResponseEntity<PropertyDetails>(propertyService.addProperty(propertyDetails), HttpStatus.CREATED);
	}

	@PutMapping("/property/{id}")
	public ResponseEntity<PropertyDetails> updateProperty(@RequestBody PropertyDetails propertyDetails,@PathVariable long id) {
		return new ResponseEntity<PropertyDetails>(propertyService.updateproperty(propertyDetails,id), HttpStatus.OK);
	}

	@GetMapping("/property/{id}")
	public ResponseEntity<PropertyDetails> viewProperty(@PathVariable long id) {
		return new ResponseEntity<PropertyDetails>(propertyService.viewProperty(id), HttpStatus.OK);
	}

	@PostMapping("/searchProperty/{key}")
	public ResponseEntity<List<PropertyDetails>> searchProperty(@PathVariable String key) {

		return new ResponseEntity<List<PropertyDetails>>(propertyService.searchProperty(key), HttpStatus.OK);
	}
}
