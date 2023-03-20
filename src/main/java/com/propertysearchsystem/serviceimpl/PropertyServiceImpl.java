package com.propertysearchsystem.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propertysearchsystem.dto.PropertyInfo;
import com.propertysearchsystem.model.PropertyDetails;
import com.propertysearchsystem.repository.PropDetailsRepo;
import com.propertysearchsystem.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
	

	@Autowired
	PropDetailsRepo propDetailsRepo;

	@Override
	public PropertyDetails addProperty(PropertyDetails propertyDetails) {
		// TODO Auto-generated method stub
		return propDetailsRepo.save(propertyDetails);
	}

	@Override
	public PropertyDetails updateproperty(PropertyDetails propertyDetails, long id) {
		PropertyDetails pro = propDetailsRepo.findById(id).get();
		return propDetailsRepo.save(propertyDetails) ;
	}

	@Override
	public PropertyDetails deleteProperty( long id) {
		// TODO Auto-generated method stub
		PropertyDetails pro = propDetailsRepo.findById(id).get();
		propDetailsRepo.deleteById(id);
		return pro;
	}

	@Override
	public PropertyDetails viewProperty(long id) {
		return propDetailsRepo.findById(id).get();
	}

	@Override
	public List<PropertyDetails> searchProperty(String key) {
		List<PropertyDetails> propertyDetails = propDetailsRepo.findAll();
		return propertyDetails.stream().filter(p->  p.getAddress().equals(key)||p.getType().equals(key) ).collect(Collectors.toList()) ;
	}


}
