package com.despegar.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.despegar.jav.exceptions.WalletCantBeNegative;
import com.despegar.jav.service.TripGenerator;

@ContextConfiguration(locations = { "classpath:application-contextTest.xml" })
public class TripGeneratorIntegrationTest extends AbstractJUnit4SpringContextTests {
	private TripGenerator tripGenerator; 
	@Before
	public void setUp(){
		tripGenerator = (TripGenerator) applicationContext.getBean("tripGenerator");
	}
	@Test
	public void testSpring(){	
		assertNotNull(tripGenerator);
	}
	@Test
	public void testTripGenerator(){
		assertNotNull(tripGenerator.generateTrip(1000.2 , "BUE"));
	}
	@Test(expected = WalletCantBeNegative.class)
	public void generateTripExceptionTest(){	
	    	tripGenerator.generateTrip(-12.2, "BUE");
	} 
}

