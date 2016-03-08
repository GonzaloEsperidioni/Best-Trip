package com.despegar.jav.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.despegar.jav.App;
import com.despegar.jav.domain.Destination;
import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.FlightWithRoute;
import com.despegar.jav.domain.TopRoute;
import com.despegar.jav.domain.Trip;

public class TripGenerator {


	private FlightsPrice flightPrice;
	private TopRoutesReader routes;
	
	public TripGenerator(FlightsPrice flightPrice , TopRoutesReader routes){
		this.flightPrice = flightPrice;
		this.routes = routes;
	}
	
	public List<TopRoute> getRoutes(){
		return routes.getTopRoutes();
	}
	public Trip generateTrip(double money, String from){
		String location = from;
		Trip trip = new Trip(money);
		//Destination test = new Destination("LLL", new Flight("MALASIA", 300.1));
		//trip.addDestination(test);
		Destination destinationNew = this.searchDestination(location, trip);
		this.travel(destinationNew, trip);
		
		while(this.canITravel(destinationNew, trip)){
			destinationNew = this.searchDestination(location, trip);
			this.travel(destinationNew, trip);
		}
		
		return trip;
		
	}
	
	public void travel(Destination destinationToTravel, Trip trip){
			trip.payAmount(destinationToTravel.getFlight().getAmount());
			trip.addDestination(destinationToTravel);
	}
	public boolean canITravel(Destination destinationToTravel, Trip trip){
		return trip.getWallet() > destinationToTravel.getFlight().getAmount();
	}
	public Destination searchDestination(String location, Trip trip){
		String from = location;
		if( trip.lastCity() != null ) { from = trip.lastCity(); }
		List<TopRoute> routesAvailables = routes.getTopRoutesFor(from);
		List<String> visitedCities = trip.getCitiesVisited();
		routesAvailables = this.filterVisitedCities(visitedCities, routesAvailables);
		FlightWithRoute cheapestFlight = this.getCheapestFlight(routesAvailables);;
		Destination destinationReturn = new Destination(
				cheapestFlight.getRoute().getTo(),// Seteo la ruta hacia donde va!
				cheapestFlight.getFlight()); //Le seteo el flight
		return destinationReturn; //TODO devuelve destination para agregar.
	}
	public List<TopRoute> filterVisitedCities (List<String> visitedCities, List<TopRoute> routesToFilter){
		List<TopRoute> filteredRoutes = new ArrayList<TopRoute>();
		if(visitedCities.isEmpty()) { return routesToFilter; }
		for (TopRoute topRoute : routesToFilter) {
			for (String visitedcities : visitedCities) {
				if(!topRoute.getTo().equals(visitedcities)){
					filteredRoutes.add(topRoute);
				}
			}
		}
		return filteredRoutes;
	}
	public FlightWithRoute getCheapestFlight(List<TopRoute> listaRutas){
		Flight cheapestFlight = new Flight("primero", 1000000000000.0); // Para primera comparacion!
		TopRoute cheapestRoute = new TopRoute();
		for (TopRoute topRoute : listaRutas) {
			Flight flightemp = flightPrice.getFlightPrice(topRoute); //TODO Ruta devuelva pais
			if(flightemp.getAmount() < cheapestFlight.getAmount()){
				cheapestFlight = flightemp;
				cheapestRoute = topRoute;
			}			
		}
		return new FlightWithRoute(cheapestFlight, cheapestRoute); //TODO tuve que crear esta clase pq no podia pasar la ruta del vuelo.
	}
	
}
