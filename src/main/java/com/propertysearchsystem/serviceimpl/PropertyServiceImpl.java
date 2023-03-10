package com.propertysearchsystem.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.propertysearchsystem.dto.PropertyInfo;
import com.propertysearchsystem.model.PropertyDetails;
import com.propertysearchsystem.repository.PropDetailsRepo;
import com.propertysearchsystem.service.PropertyService;

@Service
public class PropertyServiceImpl implements PropertyService {
	

	private PropDetailsRepo propDetailsRepo;

	public PropertyServiceImpl(PropDetailsRepo propDetailsRepo) {
		super();
		this.propDetailsRepo = propDetailsRepo;
	}

	@Override
	public PropertyInfo createNewProperty(PropertyInfo propertyInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyDetails addProperty(PropertyDetails propertyDetails) {
		// TODO Auto-generated method stub
		return propDetailsRepo.save(propertyDetails);
	}

	@Override
	public PropertyDetails updateproperty(PropertyDetails propertyDetails, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyDetails deleteProperty(PropertyDetails propertyDetails, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
