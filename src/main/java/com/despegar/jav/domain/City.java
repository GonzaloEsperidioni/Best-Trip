package com.despegar.jav.domain;

public class City {
	private String name;
	private String country;
	private String iataCode;
	
	public City(String name, String iataCode){
		this.setName(name);
		this.setIataCode(iataCode);
	}
	
	public String getCountry(){
		return country;
	}
	
	public void setCountry(String country){
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
}
