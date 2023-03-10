package com.propertysearchsystem.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PropertyOwner {
@Id	
@GeneratedValue(strategy = GenerationType.IDENTITY)	
private int oid;	
private String firstName;
private String lastName;

@OneToOne(cascade = CascadeType.ALL)
private PropertyDetails propertydetails;
}
