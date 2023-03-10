package com.propertysearchsystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PropertyInfo {

private String address;
private String type;
private OwnerInfo ownerInfo;
}
