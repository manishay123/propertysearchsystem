//package com.propertysearchsystem;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.propertysearchsystem.controller.PropertyController;
//import com.propertysearchsystem.dto.SearchRequestDTO;
//import com.propertysearchsystem.model.PropertyDetails;
//import com.propertysearchsystem.model.PropertyOwner;
//import com.propertysearchsystem.service.PropertyService;
//
//@SpringBootTest
//public class ControllerMockitoTests {
//	
//	@Mock
//	PropertyService propertyService;
//	
//	@InjectMocks
//	PropertyController propertyController;
//	 
//List<PropertyDetails> propertyDetails;
//PropertyOwner propOwner;
//PropertyDetails propDetails;
//
//
//
//
//
//@Test
//public void test_getAllProprty() {
//	
//	propertyDetails = new  ArrayList<PropertyDetails>();
//	propertyDetails.add(new PropertyDetails(1, "Lucknow", "2BHK", "For Rent",1000 ,true,( new PropertyOwner(1, "manisha", "yadav"))));
//	when(propertyService.getAllProperty()).thenReturn(propertyDetails);
//ResponseEntity<List<PropertyDetails>> res=	propertyController.getAllProperty();
//assertEquals(HttpStatus.OK, res.getStatusCode());
//assertEquals(1,res.getBody().size());
//}
//
//@Test
//public void test_addProperty() {
//	
//	propDetails = new PropertyDetails(1, "Lucknow", "2BHK", "For Rent",1000 ,true,( new PropertyOwner(1, "manisha", "yadav")));
//	when(propertyService.addProperty(propDetails)).thenReturn(propDetails);
//	ResponseEntity<PropertyDetails> res = propertyController.addProperty(propDetails);
//	assertEquals(propDetails,res.getBody());
//}
//
//@Test
//public void test_updatePropety() {
//	propDetails = new PropertyDetails(1, "Lucknow", "2BHK", "For Rent",1000 ,true,( new PropertyOwner(1, "manisha", "yadav")));
//	int propId= 1;
//	when(propertyService.updateProperty(propDetails,propId)).thenReturn(propDetails);
//	ResponseEntity<PropertyDetails> res = propertyController.updateProperty(propDetails, propId);
//	assertEquals(1,res.getBody().getId());
//	assertEquals("Lucknow",res.getBody().getAddress());
//	assertEquals("2BHK",res.getBody().getType());
//	assertEquals("For Rent",res.getBody().getDescription());
//	assertEquals(1000,res.getBody().getTaxAmount());
//	assertEquals(true,res.getBody().isTaxStatus());
//	assertEquals(1,res.getBody().getPropertyOwner().getId());
//	assertEquals("manisha",res.getBody().getPropertyOwner().getFirstName());
//	assertEquals("yadav",res.getBody().getPropertyOwner().getLastName());
//		
//		
//	}
//	@Test
//	public void test_viewProperty() {
//		int propId = 1;
//		propDetails= new PropertyDetails(1, "Lucknow", "2BHK", "For Rent",1000 ,true,( new PropertyOwner(1, "manisha", "yadav")));
//		when(propertyService.viewProperty(propId)).thenReturn(propDetails);
//		ResponseEntity<PropertyDetails> res = propertyController.viewProperty(propId);
//		assertEquals(propId,res.getBody().getId());
//	}
//	
//	@Test
//	public void test_searchProperty() {
//		String address = "lucknow";
//		propertyDetails = new  ArrayList<PropertyDetails>();
//		propertyDetails.add(new PropertyDetails(1, "lucknow", "2BHK", "For Rent",1000 ,true,( new PropertyOwner(1, "manisha", "yadav"))));
//		when(propertyService.searchProperty(address)).thenReturn(propertyDetails);
//		ResponseEntity<List<PropertyDetails>> res = propertyController.searchProperty(address);
//		assertEquals(HttpStatus.OK, res.getStatusCode());
//	}
//	
//	@Test
//	public void test_searchPropertyWithFields() {
//		propertyDetails = new  ArrayList<PropertyDetails>();
//		propertyDetails.add(new PropertyDetails(1, "lucknow", "2BHK", "For Rent",1000 ,true,( new PropertyOwner(1, "manisha", "yadav"))));
//		SearchRequestDTO searchDTO = new SearchRequestDTO("manisha", "yadav", "lucknow", "2BHK");
//		when(propertyService.searchPropertyWithProperty(searchDTO )).thenReturn(propertyDetails);
//		ResponseEntity<List<PropertyDetails>> res = propertyController.searchPropertyWithFields(searchDTO);
//		assertEquals(HttpStatus.OK, res.getStatusCode());
//	}
//	
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
