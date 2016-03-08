package com.despegar.jav.domain;

public class FlightWithRoute {

	private Flight flight;
	private TopRoute route;
	
	public FlightWithRoute(Flight flight, TopRoute route){
		this.flight = flight;
		this.route = route;
	}
	public Flight getFlight(){
		return flight;
	}
	public TopRoute getRoute(){
		return route;
	}
}
