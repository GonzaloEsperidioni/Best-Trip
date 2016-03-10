package webapp.webapp;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;


import org.junit.Before;
import org.junit.Test;

import com.despegar.jav.domain.Flight;
import com.despegar.jav.domain.TopRoute;
import com.despegar.jav.domain.Trip;
import com.despegar.jav.service.FlightsPrice;
import com.despegar.jav.service.TopRoutesReader;
import com.despegar.jav.service.TripGenerator;

public class TripGeneratorTest {
	  private TripGenerator tripGenerator;
	  public Trip trip;
	  public TopRoute route;
	  public TopRoutesReader trr;
	  private FlightsPrice flightprice;

	    @Before
	    public void setUp(){
	    	flightprice = mock(FlightsPrice.class);
	    	trr = mock(TopRoutesReader.class);

	    	tripGenerator = new TripGenerator(flightprice, trr);
	    	
	    }
	    
	    @Test
	    public void getCheapestFlightTest(){
	    	TopRoute ruta1 = new TopRoute();
	    	TopRoute ruta2 = new TopRoute();
	    	Flight flight1 = new Flight("Malasia", 800.0);
	    	Flight flight2 = new Flight("Aerolinea 2", 890.0);
	    	ruta1.setFrom("BUE");
	    	ruta1.setTo("MIA");
	    	ruta2.setFrom("LAS");
	    	ruta2.setTo("TEST");
	    	List<TopRoute> lista = new ArrayList<TopRoute>();
	    	lista.add(ruta1);
	    	lista.add(ruta2);
	    	
	    	when(flightprice.getFlightPrice(ruta1)).thenReturn(flight1);
	    	when(flightprice.getFlightPrice(ruta2)).thenReturn(flight2);
	    	
	    	assertEquals(tripGenerator.getCheapestFlight(lista).getFlight(), flight1);
	    }
}
