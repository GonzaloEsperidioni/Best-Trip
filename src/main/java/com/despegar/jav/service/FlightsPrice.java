package com.despegar.jav.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.TopRoute;

public class FlightsPrice {
	
	public Flight getFlightPrice(TopRoute route){
//		RestTemplate restTemplate = new RestTemplate();
//		String urlToPost = "http://backoffice.despegar.com/v3/flights/search-stats/cheapest-itineraries?channel=site"
//				+ "&cheapest_criteria=total"
//				+ "&search_type=roundtrip"
//				+ "&offset=0"
//				+ "&limit=1"
//				+ "&currency=USD"
//				+ "&country=AR"
//				+ "&from=BUE"
//				+ "&to=MIA";
//		String jsonFlight = restTemplate.getForObject(urlToPost,
//				String.class);
		
		//JSONObject json = new JSONObject(jsonFlight);
		//JSONArray paging = json.getJSONArray(jsonFlight);
		
	//	return new Flight("Malasia Airlines", 1000.0);
	//	String airline = paging.getString("total");
	    
		return new Flight("airline", 1000.0);
	}
}
