package com.propertysearchsystem.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
private long id;
private String firstName;
private String lastName;
@OneToOne(cascade = CascadeType.ALL, mappedBy = "propertyOwner",fetch = FetchType.LAZY)
@JsonBackReference
private  PropertyDetails propertyDetails;

}
