package com.despegar.test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.despegar.jav.domain.Destination;
import com.despegar.jav.domain.Trip;

public class TripTest {
	public Destination destination;
	public Trip trip;
	 @Before
	    public void setUp(){
		 	destination = new Destination("LASTCITYTEST", null);
	    	trip = new Trip(1000.0);
	 }
	 @Test
	 public void payTest()
	 {
		 trip.payAmount(500.0);
		 assertEquals(trip.getWallet() , 500.0, 0.01);
	 }
	 @Test
	 public void emptyDestinationsTest(){
		 assertEquals(trip.lastCity(), null);
	 }
	 @Test
	 public void DestinationsTest(){
		 trip.addDestination(destination);
		 assertEquals(trip.lastCity(), "LASTCITYTEST");
	 }
	 
}
