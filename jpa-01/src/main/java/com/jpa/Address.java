package com.jpa;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Embeddable
public class Address {
	
	//value type : entity 에 속하는 부가정보 (address 는 account 에 속함)
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zipCode;
	
}
