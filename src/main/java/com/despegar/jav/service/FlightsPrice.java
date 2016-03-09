package com.despegar.jav.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.FlightJson;
import com.despegar.jav.domain.TopRoute;

public class FlightsPrice {
	
	public Flight getFlightPrice(TopRoute route){
		FlightJson flightGet = null;
		try {
			flightGet = httpFlightService.getFlightPrice(route);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Flight(flightGet.getAirline(), flightGet.getTotal());
		
	}
}
