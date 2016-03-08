package com.despegar.jav.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Trip {
	
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
		wallet -= toPay;
	}
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
