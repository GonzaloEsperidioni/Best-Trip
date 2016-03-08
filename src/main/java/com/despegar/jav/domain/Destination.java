package com.despegar.jav.domain;


public class Destination {
	
	private String cityCode;
	private Flight flight;
	
	public Destination(){
		
	}
	public Destination(String cityCode, Flight flight){
		this.setCityCode(cityCode);
		this.setFlight(flight);
	}
	

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
}
