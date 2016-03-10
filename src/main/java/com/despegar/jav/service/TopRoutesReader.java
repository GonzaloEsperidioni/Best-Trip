package com.despegar.jav.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.despegar.jav.domain.TopRoute;


public class TopRoutesReader {
	private static final Logger LOGGER = LoggerFactory.getLogger(TopRoutesReader.class);
	private TopRoutesReaderConector trrc;
	public TopRoutesReader(TopRoutesReaderConector trrc){
		this.trrc = trrc;
	}
//	private TopRoutesReaderConector rrc = new TopRoutesReaderConector();
	public List<TopRoute> getTopRoutesFor(String location){
		List<TopRoute> routesFromLocation = new ArrayList<TopRoute>();
		LOGGER.info("Obtaining Routes from : {} ", location);
		for (TopRoute route : trrc.getTopRoutes()) {
			if(route.getFrom().equals(location)){
				routesFromLocation.add(route);
			}
		}
		return routesFromLocation;
	}
	
}
