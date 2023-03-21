package com.propertysearchsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class PropertyDetails {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String address;
private String type;
private String description;
private float taxAmount;
private boolean taxStatus;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "propertyOwnerId")
    @JsonManagedReference
    private PropertyOwner propertyOwner;

}
