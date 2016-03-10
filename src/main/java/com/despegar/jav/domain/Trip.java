package com.despegar.jav.domain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Trip {
	private static final Logger LOGGER = LoggerFactory.getLogger(Trip.class);
	private double wallet;
	private List<Destination> destinations = new ArrayList<Destination>();

	
	public Trip(Double wallet){
		this.wallet = wallet;
	}
	
	public double getWallet(){
		return wallet;
	}
	
	public void addDestination(Destination destination){
		destinations.add(destination);
	}
	
	public String lastCity(){
		if(destinations.isEmpty()){
			return null;
		}
		else
		{
			return destinations.get(destinations.size() - 1).getCityCode();
		}
	}
	public List<Destination> getDestinations(){
		return destinations;
	}
	public void payAmount(Double toPay){
		LOGGER.info("To Pay : {}", toPay);
		wallet -= toPay;
		LOGGER.info("Wallet : {}", wallet);
	}
	@JsonIgnore
	public List<String> getCitiesVisited(){
		List<String> citiesVisited = new ArrayList<String>();
		citiesVisited.clear();
		if (this.getDestinations().isEmpty()) { return citiesVisited; }
		for (Destination destination : this.getDestinations()) {
			citiesVisited.add(destination.getCityCode());
		}
		return citiesVisited;
	}
}
