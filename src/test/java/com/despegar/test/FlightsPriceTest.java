package com.despegar.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Before;
import org.junit.Test;

import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.FlightJson;
import com.despegar.jav.domain.TopRoute;
import com.despegar.jav.service.FlightsPrice;
import com.despegar.jav.service.HttpFlightService;

public class FlightsPriceTest {
		private FlightsPrice flightPrice;
		private HttpFlightService httpFlightService;
		private TopRoute routeFalsa;
		private FlightJson flightjson;
		@Before
		public void setUp(){
			
			httpFlightService = new HttpFlightService();
			routeFalsa = new TopRoute();
			flightjson = new FlightJson();
			routeFalsa.setFrom("BUE");
			routeFalsa.setTo("MIA");
			httpFlightService = mock(HttpFlightService.class);
			flightjson = mock(FlightJson.class);
			flightPrice = new FlightsPrice(httpFlightService);
		}
		
		@Test
		public void getFlightPriceTest() throws ClientProtocolException, IOException{ 
			
		when(flightjson.getAirline()).thenReturn("Malasia");
		when(flightjson.getTotal()).thenReturn(100.5);
		when(httpFlightService.getFlightPrice(routeFalsa)).thenReturn(flightjson);		
		assertEquals( flightPrice.getFlightPrice(routeFalsa).getAmount() , new Flight("Malasia", 100.5).getAmount());
		
		}
}
