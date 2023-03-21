package com.propertysearchsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.propertysearchsystem.model.PropertyDetails;

@Repository
public interface PropDetailsRepo extends JpaRepository<PropertyDetails,Long > {


}
