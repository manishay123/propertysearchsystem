package com.propertysearchsystem.controller;


import com.propertysearchsystem.dto.SearchRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.propertysearchsystem.model.PropertyDetails;
import com.propertysearchsystem.service.PropertyService;

import java.util.List;

@RestController
@CrossOrigin
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PreAuthorize("hasRole('User') || hasRole('Admin')")
	@GetMapping("/property")
	public ResponseEntity<List<PropertyDetails>> getAllProperty() {
		return new ResponseEntity<List<PropertyDetails>>(propertyService.getAllProperty(), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('Admin')")
	@PostMapping("/property")
	public ResponseEntity<PropertyDetails> addProperty(@RequestBody PropertyDetails propertyDetails) {

		return new ResponseEntity<PropertyDetails>(propertyService.addProperty(propertyDetails), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('Admin')")
	@PutMapping("/property/{id}")
	public ResponseEntity<PropertyDetails> updateProperty(@RequestBody PropertyDetails propertyDetails,@PathVariable long id) {

		return new ResponseEntity<PropertyDetails>(propertyService.updateProperty(propertyDetails,id), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('Admin')")
	@DeleteMapping("/property/{id}")
	public ResponseEntity<PropertyDetails> deleteProperty(@PathVariable long id) {

		return new ResponseEntity<PropertyDetails>(propertyService.deleteProperty(id), HttpStatus.OK);
	}
	
	
	@PreAuthorize("hasRole('User') || hasRole('Admin')")
	@GetMapping("/property/{id}")
	public ResponseEntity<PropertyDetails> viewProperty(@PathVariable long id) {
		return new ResponseEntity<PropertyDetails>(propertyService.viewProperty(id), HttpStatus.OK);
	}
	@PreAuthorize("hasRole('User') || hasRole('Admin')")
	@PostMapping("/searchProperty/{key}")
	public ResponseEntity<List<PropertyDetails>> searchProperty(@PathVariable String key) {
		return new ResponseEntity<List<PropertyDetails>>(propertyService.searchProperty(key), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('User') || hasRole('Admin')")
	@PostMapping("/searchPropertyWithField")
	public ResponseEntity<List<PropertyDetails>> searchPropertyWithFields(@RequestBody SearchRequestDTO searchRequestDTO) {
		return new ResponseEntity<List<PropertyDetails>>(propertyService.searchPropertyWithProperty(searchRequestDTO), HttpStatus.OK);
	}

}

