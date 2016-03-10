package webapp.webapp;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.despegar.jav.domain.TopRoute;
import com.despegar.jav.service.TopRoutesReader;
import com.despegar.jav.service.TopRoutesReaderConector;

public class TopRoutesReaderTest {
	private TopRoutesReader routesReader;
	private TopRoutesReaderConector routesReaderConector;
	private TopRoute route;
	@Before
    public void setUp(){
		routesReaderConector = new TopRoutesReaderConector();
		route = new TopRoute();
		routesReaderConector = mock(TopRoutesReaderConector.class);
		routesReader = new TopRoutesReader(routesReaderConector);
    }
	@Test
	public void getRoutesLocationTest(){
		
		route.setFrom("TEST");
		route.setTo("MIA");
		List<TopRoute> routes = new ArrayList<TopRoute>();
		routes.add(route);
		
		when(routesReaderConector.getTopRoutes()).thenReturn(routes);
		
		assertEquals(routesReader.getTopRoutesFor("TEST").get(0).getTo(), "MIA");
		
		
	}
    
}
