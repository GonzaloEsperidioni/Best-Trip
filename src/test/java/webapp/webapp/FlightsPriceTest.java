package webapp.webapp;

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
			flightPrice = new FlightsPrice();
			httpFlightService = new HttpFlightService();
			routeFalsa = new TopRoute();
			flightjson = new FlightJson();
			routeFalsa.setFrom("BUE");
			routeFalsa.setTo("MIA");
			httpFlightService = mock(HttpFlightService.class);
		}
		
		@Test
		public void getFlightPriceTest() throws ClientProtocolException, IOException{ 
		flightjson.setAirline("Malasia");
		flightjson.setTotal(1000.0);
	
		when(httpFlightService.getFlightPrice(routeFalsa)).thenReturn(flightjson);
		
		assertEquals( flightPrice.getFlightPrice(routeFalsa) , new Flight("Malasia", 1000.0).getAmount());
		
		}
}
