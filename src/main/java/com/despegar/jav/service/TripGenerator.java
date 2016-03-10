package com.despegar.jav.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.despegar.jav.domain.Destination;
import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.FlightWithRoute;
import com.despegar.jav.domain.TopRoute;
import com.despegar.jav.domain.Trip;
import com.despegar.jav.exceptions.WalletCantBeNegative;

public class TripGenerator {

	private static final Logger LOGGER = LoggerFactory.getLogger(TripGenerator.class);
	private FlightsPrice flightPrice;
	private TopRoutesReader routes;
	
	public TripGenerator(FlightsPrice flightPrice , TopRoutesReader routes){
		this.flightPrice = flightPrice;
		this.routes = routes;
	}
	public Object generateTrip(double money, String from){
		if(money < 0){  
			LOGGER.error("", new WalletCantBeNegative());
			throw new WalletCantBeNegative(); 
			}
		String location = from;
		Trip trip = new Trip(money);
		Destination first = new Destination(location, null);
		this.travel(first, trip);
		Destination destinationNew = this.searchDestination(location, trip);
		LOGGER.info("Location Trip : {} Wallet : {}",location ,money);
		LOGGER.info("Destination Found : {} , Price: {}" ,destinationNew.getCityCode(), destinationNew.getFlight().getAmount());
		if(this.canITravel(destinationNew, trip)){
		LOGGER.info("Can Travel? : {}" , this.canITravel(destinationNew, trip));
		this.travel(destinationNew, trip);
		}
		
		while(this.canITravel(destinationNew, trip)){
			destinationNew = this.searchDestination(location, trip);
			if(destinationNew.getCityCode() == null){ return trip; }
			this.travel(destinationNew, trip);
		}
		LOGGER.info("Trip Generator has run Successfully");
		return trip;
		
	}
	
	public void travel(Destination destinationToTravel, Trip trip){
		if(destinationToTravel.getFlight() != null) {
			trip.payAmount(destinationToTravel.getFlight().getAmount());
		}
			trip.addDestination(destinationToTravel);
			LOGGER.info("Destination Added Successfully");
		
	}
	public boolean canITravel(Destination destinationToTravel, Trip trip){
		return trip.getWallet() > destinationToTravel.getFlight().getAmount();
	}
	public Destination searchDestination(String location, Trip trip){
		String from = location;
		if( trip.lastCity() != null ) {
			from = trip.lastCity();
		}
		else { 
			trip.getCitiesVisited().add(location); //Añado la primer location para que no repita
		}
		List<TopRoute> routesAvailables = routes.getTopRoutesFor(from);
		List<String> visitedCities = trip.getCitiesVisited();
		LOGGER.info("Obtaining routes");
		routesAvailables = this.filterVisitedCities(visitedCities, routesAvailables);
		FlightWithRoute cheapestFlight = this.getCheapestFlight(routesAvailables);;
		Destination destinationReturn = new Destination(
				cheapestFlight.getRoute().getTo(),// Seteo la ruta hacia donde va!
				cheapestFlight.getFlight()); //Le seteo el flight
		return destinationReturn; //TODO devuelve destination para agregar.
	}
	public List<TopRoute> filterVisitedCities (List<String> visitedCities, List<TopRoute> routesToFilter){
		List<TopRoute> filteredRoutes = new ArrayList<TopRoute>();
		LOGGER.info("Filtering Visited Cities");
		if(visitedCities.isEmpty()) 
			{ return routesToFilter; }
		else {
			if(routesToFilter != null){
				for (TopRoute topRoute : routesToFilter) {
						if(!visitedCities.contains(topRoute.getTo().toString())){
							filteredRoutes.add(topRoute);
						}
				}
			}
			return filteredRoutes;
		}
	}
	public FlightWithRoute getCheapestFlight(List<TopRoute> listaRutas){
		LOGGER.info("Searching Cheapest Flight");
		Flight cheapestFlight = new Flight("primero", 1000000000000.0); // Para primera comparacion!
		TopRoute cheapestRoute = new TopRoute();
		for (TopRoute topRoute : listaRutas) {
			Flight flightemp = flightPrice.getFlightPrice(topRoute); //TODO Ruta devuelva pais
			if(flightemp.getAmount() < cheapestFlight.getAmount() & flightemp.isValid()){
				cheapestFlight = flightemp;
				cheapestRoute = topRoute;
			}			
		}
		return new FlightWithRoute(cheapestFlight, cheapestRoute); //TODO tuve que crear esta clase pq no podia pasar la ruta del vuelo.
	}
	
}
