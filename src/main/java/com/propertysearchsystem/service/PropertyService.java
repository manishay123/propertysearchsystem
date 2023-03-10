package com.propertysearchsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.propertysearchsystem.dto.PropertyInfo;
import com.propertysearchsystem.model.PropertyDetails;


public interface PropertyService {
PropertyInfo createNewProperty(PropertyInfo propertyInfo);
PropertyDetails addProperty(PropertyDetails propertyDetails);
PropertyDetails updateproperty(PropertyDetails propertyDetails, long id);
PropertyDetails deleteProperty(PropertyDetails propertyDetails, long id);
//List<PropertyDetails> searchProperty(String address, String type); 
}
