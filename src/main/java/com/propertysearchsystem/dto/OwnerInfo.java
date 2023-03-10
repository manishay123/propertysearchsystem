package com.propertysearchsystem.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Service
@NoArgsConstructor
public class OwnerInfo {
	private String firstName;
	private String lastname;
}
