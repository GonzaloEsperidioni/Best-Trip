package webapp.webapp;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.despegar.jav.domain.Trip;

public class TripTest {
	
	public Trip trip;
	 @Before
	    public void setUp(){
	    	trip = new Trip(1000.0);
	 }
	 @Test
	 public void payTest()
	 {
		 trip.payAmount(500.0);
		 assertEquals(trip.getWallet() , 500.0, 0.01);
	 }
}
