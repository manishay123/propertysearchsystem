package com.propertysearchsystem.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.propertysearchsystem.dto.SearchRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<PropertyDetails> getAllProperty() {
		List<PropertyDetails> propertyDetails = new ArrayList<>();
		propDetailsRepo.findAll().forEach( e-> propertyDetails.add(e) );
		return propertyDetails;
	}

	@Override
	public PropertyDetails updateProperty(PropertyDetails propertyDetails, long id) {
		PropertyDetails pro = propDetailsRepo.findById(id).get();
		propertyDetails.setId(pro.getId());
		propertyDetails.getPropertyOwner().setId(pro.getPropertyOwner().getId());
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
		List<PropertyDetails> propertyDetails = new ArrayList<>();
		propDetailsRepo.findAll().forEach( e-> propertyDetails.add(e) );
		return propertyDetails.stream().filter(p->  p.getPropertyOwner().getFirstName().equals(key)||p.getPropertyOwner().getLastName().equals(key) ).collect(Collectors.toList()) ;
	}

	@Override
	public List<PropertyDetails> searchPropertyWithProperty(SearchRequestDTO searchRequestDTO) {
		List<PropertyDetails> propertyDetails = new ArrayList<>();
		propDetailsRepo.findAll().forEach( e-> propertyDetails.add(e) );
		return propertyDetails.stream().filter(p->  p.getAddress().equals(searchRequestDTO.getAddress())||p.getType().equals(searchRequestDTO.getPropertyType())
				||p.getPropertyOwner().getFirstName().equals(searchRequestDTO.getFirstName())||p.getPropertyOwner().getLastName().equals(searchRequestDTO.getLastName()) ).collect(Collectors.toList()) ;
	}


}
