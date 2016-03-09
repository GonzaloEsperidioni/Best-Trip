package com.despegar.jav.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.despegar.jav.domain.TopRoute;
import com.despegar.jav.json.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;

public class TopRoutesReader {

	public static void main(String[] args) {
		TopRoutesReader reader = new TopRoutesReader();
		System.out.println(reader.getTopRoutes());
		System.out.println(reader.getTopRoutesFor("BUE"));
	}

	public List<TopRoute> getTopRoutes() {
		JsonFactory jsonFactory = new JsonFactory();
		InputStream inputStream = TopRoutesReader.class.getResourceAsStream("top_routes.json");
		return jsonFactory.fromJson(new InputStreamReader(inputStream), new TypeReference<List<TopRoute>>() {
		});
	}

	public List<TopRoute> getTopRoutesFor(String location){
		List<TopRoute> routesFromLocation = new ArrayList<TopRoute>();
		
		for (TopRoute route : this.getTopRoutes()) {
			if(route.getFrom().equals(location)){
				routesFromLocation.add(route);
			}
		}
		return routesFromLocation;
	}
	
}
