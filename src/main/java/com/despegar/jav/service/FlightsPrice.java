package com.despegar.jav.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.TopRoute;

public class FlightsPrice {
	
	public Flight getFlightPrice(TopRoute route){

//		String url = "http://backoffice.despegar.com/v3/flights/search-stats/cheapest-itineraries?channel=site"
//				+ "&cheapest_criteria=total"
//				+ "&search_type=roundtrip"
//				+ "&offset=0"
//				+ "&limit=1"
//				+ "&currency=USD"
//				+ "&country=AR"
//				+ "&from=BUE"
//				+ "&to=MIA";
//
//		HttpClient client = HttpClientBuilder.create().build();
//		HttpGet request = new HttpGet(url);
//
//		// add request header
//		request.addHeader("User-Agent", "MySuperUserAgent");
//		HttpResponse response = client.execute(request);
//
//		System.out.println("Response Code : " 
//	                + response.getStatusLine().getStatusCode());
//
//		BufferedReader rd = new BufferedReader(
//			new InputStreamReader(response.getEntity().getContent()));
//
//		StringBuffer result = new StringBuffer();
//		String line = "";
//		while ((line = rd.readLine()) != null) {
//			result.append(line);
//		}
		
		return new Flight("Malasia Airlines", 1000.0);
		
	}
}
