package com.propertysearchsystem.service;

import java.util.List;

import com.propertysearchsystem.dto.SearchRequestDTO;
import com.propertysearchsystem.model.PropertyDetails;


public interface PropertyService {

PropertyDetails addProperty(PropertyDetails propertyDetails);
List<PropertyDetails> getAllProperty();
PropertyDetails updateProperty(PropertyDetails propertyDetails, long id);
PropertyDetails deleteProperty( long id);
PropertyDetails viewProperty( long id);

List<PropertyDetails> searchProperty(String key);
List<PropertyDetails> searchPropertyWithProperty(SearchRequestDTO searchRequestDTO);
}
