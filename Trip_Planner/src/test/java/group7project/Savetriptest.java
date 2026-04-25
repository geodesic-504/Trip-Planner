package group7project;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class SavetripTest
{
    // Test Case 1: Create trip with name only
    // Expected Result: getTripName() == "My Trip"; getStops().size() == 0; isSaved() == false
    @Test
    public void testDefaultConstructor()
    {
        Trip trip = new Trip("My Trip");
 
        assertEquals("My Trip", trip.getTripName());
        assertEquals(0, trip.getStops().size());
        assertFalse(trip.isSaved());
    }
 
    // Test Case 2: Create trip with name, stops, and route
    // Expected Result: getStops().size() == 2; getRoute() == route1
    @Test
    public void testFullConstructor()
    {
        Stop stop1 = new Stop("Stop1", "Park");
        Stop stop2 = new Stop("Stop2", "Museum");
        Route route1 = new Route(stop1, stop2, 10.0f, 20.0f);
 
        Trip trip = new Trip("CityTour", List.of(stop1, stop2), route1);
 
        assertEquals(2, trip.getStops().size());
        assertEquals(route1, trip.getRoute());
    }
 
    // Test Case 3: Add a stop to a trip
    // Expected Result: getStops().size() == 1 after one addStop()
    @Test
    public void testAddStop()
    {
        Trip trip = new Trip("ParkRoute");
        Stop newStop = new Stop("A", "Park");
 
        trip.addStop(newStop);
 
        assertEquals(1, trip.getStops().size());
    }
 
    // Test Case 4: Remove a stop that was previously added
    // Expected Result: getStops().contains(stop1) == false; size decreases by 1
    @Test
    public void testRemoveStop()
    {
        Trip trip = new Trip("ShopLoop");
        Stop stop1 = new Stop("Stop1", "Shop");
        Stop stop2 = new Stop("Stop2", "Cafe");
        trip.addStop(stop1);
        trip.addStop(stop2);
 
        int sizeBefore = trip.getStops().size();
        trip.removeStop(stop1);
 
        assertFalse(trip.getStops().contains(stop1));
        assertEquals(sizeBefore - 1, trip.getStops().size());
    }
 
    // Test Case 5: Set a route on a trip
    // Expected Result: getRoute().getStart() and getRoute().getEnd() match the stops used to build the route
    @Test
    public void testSetRoute()
    {
        Trip trip = new Trip("Highway1");
        Stop startStop = new Stop("R2-Start", "Highway");
        Stop endStop   = new Stop("R2-End",   "Highway");
        Route route = new Route(startStop, endStop, 50.0f, 60.0f);
 
        trip.setRoute(route);
 
        assertEquals(startStop, trip.getRoute().getStart());
        assertEquals(endStop,   trip.getRoute().getEnd());
    }
 
    // Test Case 6: Set saved to true
    // Expected Result: isSaved() == true; getDetails() contains "Saved: true"
    @Test
    public void testSetSavedTrue()
    {
        Trip trip = new Trip("SavedTrip");
 
        trip.setSaved(true);
 
        assertTrue(trip.isSaved());
        assertTrue(trip.getDetails().contains("Saved: true"));
    }
 
    // Test Case 7: Set saved back to false after setting true
    // Expected Result: isSaved() == false
    @Test
    public void testSetSavedFalseAfterTrue()
    {
        Trip trip = new Trip("UnsavedTrip");
        trip.setSaved(true);
 
        trip.setSaved(false);
 
        assertFalse(trip.isSaved());
    }
 
    // Test Case 8: getDetails() on a trip with 2 stops and saved = true
    // Expected Result: "Trip: DetailTrip | Stops: 2 | Saved: true"
    @Test
    public void testGetDetails()
    {
        Trip trip = new Trip("DetailTrip");
        trip.addStop(new Stop("Stop1", "Park"));
        trip.addStop(new Stop("Stop2", "Museum"));
        trip.setSaved(true);
 
        String details = trip.getDetails();
 
        assertEquals("Trip: DetailTrip | Stops: 2 | Saved: true", details);
    }
}

