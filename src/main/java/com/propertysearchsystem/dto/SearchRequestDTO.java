package com.propertysearchsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchRequestDTO {
    String firstName;
    String lastName;
    String address;
    String propertyType;
}
