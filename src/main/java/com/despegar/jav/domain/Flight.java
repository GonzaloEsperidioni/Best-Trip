package com.despegar.jav.domain;

public class Flight {

	private Double amount;
	private String airline;
	
	public Flight(String airline, Double amount){
		this.setAmount(amount);
		this.setAirline(airline);
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}
	
}
