package com.despegar.jav.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.despegar.jav.domain.FlightJson;
import com.despegar.jav.domain.TopRoute;
import com.fasterxml.jackson.databind.ObjectMapper;


public class httpFlightService {
	
	
    private static ObjectMapper mapper = new ObjectMapper();
    private static DefaultHttpClient httpClient = new DefaultHttpClient();

    public static  FlightJson getFlightPrice(TopRoute route)
            throws ClientProtocolException, IOException {

        HttpGet getRequest = new HttpGet(
                "http://backoffice.despegar.com/v3/flights/search-stats/cheapest-itineraries?"
                + "channel=site"
                + "&cheapest_criteria=total"
                + "&search_type=roundtrip"
                + "&offset=0"
                + "&limit=1"
                + "&currency=USD"
                + "&country=" + route.getCountry()
                + "&from=" + route.getFrom()
                + "&to=" + route.getTo());

        HttpResponse response = httpClient.execute(getRequest);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        FlightJson flightjson = mapper.readValue(rd, FlightJson.class);
        
        
        return flightjson;

    }
}


