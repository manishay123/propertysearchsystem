package com.propertysearchsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propertysearchsystem.dto.PropertyInfo;
import com.propertysearchsystem.model.PropertyDetails;

@Repository
public interface PropDetailsRepo extends JpaRepository<PropertyDetails,Long > {

	//List<PropertyInfo> findByfirstNameOraddressOrtype(String firstname, String address, String type);
	
	List<PropertyDetails> findByaddressContainingAndType(String address, String type);
}
