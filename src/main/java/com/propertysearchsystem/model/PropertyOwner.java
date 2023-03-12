package com.propertysearchsystem.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


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
