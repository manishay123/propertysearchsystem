package com.propertysearchsystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PropertyDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long pid;	
private String address;
private String type;
private String description;
private String taxAmount;
private boolean taxStatus;

}
