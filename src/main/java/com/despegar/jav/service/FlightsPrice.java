package com.despegar.jav.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.FlightJson;
import com.despegar.jav.domain.TopRoute;


public class FlightsPrice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightsPrice.class);
	private HttpFlightService httpService;
	public FlightsPrice(HttpFlightService httpService){
		this.httpService = httpService;
	}
	public Flight getFlightPrice(TopRoute route){
		FlightJson flightGet = null;
		try {
			LOGGER.info("Calling HttpFlightService, Getting Price From : {} To: {}" ,route.getFrom(),route.getTo());
			flightGet = httpService.getFlightPrice(route);
			LOGGER.info("Price : {} Airline : {}", flightGet.getTotal() ,flightGet.getAirline());
		} catch (IOException e) {
			LOGGER.error("Can't reach server connection", e);
		}
		return new Flight(flightGet.getAirline(), flightGet.getTotal());
	}
}
