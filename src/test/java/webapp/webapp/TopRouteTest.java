package webapp.webapp;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.despegar.jav.domain.TopRoute;

public class TopRouteTest {
	public TopRoute tr;
	 @Before
	    public void setUp(){
	    	tr = new TopRoute();
	    	tr.setFrom("BUE");
	    	tr.setTo("MIA");
	 }
	 @Test
	 public void getCountryTest()
	 {
		 assertEquals(tr.getCountry(), "AR");
	 }
	 @Test
	 public void getFromTest(){
		 assertEquals(tr.getFrom(), "BUE");
	 }
}
