package group7project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddRemoveStopsTest
{
    // Test Case 1: Add a valid stop to an empty trip
    // Initial State: stops = []
    // Action: addStop(new Stop("A", "Park"))
    // Expected: assertEquals(1, trip.getStops().size())
    @Test
    public void testAddValidStop()
    {
        Trip trip = new Trip("Test Trip");
        Stop stop1 = new Stop("A", "Park");

        trip.addStop(stop1);

        assertEquals(1, trip.getStops().size());
    }

    // Test Case 2: Remove a valid stop from a trip with 2 stops
    // Initial State: stops = [stop1, stop2]
    // Action: removeStop(stop1)
    // Expected: assertFalse(trip.getStops().contains(stop1))
    @Test
    public void testRemoveValidStop()
    {
        Trip trip = new Trip("Test Trip");
        Stop stop1 = new Stop("A", "Park");
        Stop stop2 = new Stop("B", "Museum");

        trip.addStop(stop1);
        trip.addStop(stop2);
        trip.removeStop(stop1);

        assertFalse(trip.getStops().contains(stop1));
    }

    // Test Case 3: Remove the only stop in the trip
    // Initial State: stops = [stop1]
    // Action: removeStop(stop1)
    // Expected: assertEquals(0, trip.getStops().size())
    @Test
    public void testRemoveOnlyStop()
    {
        Trip trip = new Trip("Test Trip");
        Stop stop1 = new Stop("A", "Park");

        trip.addStop(stop1);
        trip.removeStop(stop1);

        assertEquals(0, trip.getStops().size());
    }

    // Test Case 4: Add null stop to empty trip
    // Initial State: stops = []
    // Action: addStop(null)
    // Expected: assertThrows(NullPointerException.class)
    @Test
    public void testAddNullStop()
    {
        Trip trip = new Trip("Test Trip");

        assertThrows(NullPointerException.class, () -> trip.addStop(null));
    }

    // Test Case 5: Remove a stop that is not in the list
    // Initial State: stops = [stop1]
    // Action: removeStop(stop2)
    // Expected: assertEquals(1, trip.getStops().size())
    @Test
    public void testRemoveStopNotInList()
    {
        Trip trip = new Trip("Test Trip");
        Stop stop1 = new Stop("A", "Park");
        Stop stop2 = new Stop("B", "Museum");

        trip.addStop(stop1);
        trip.removeStop(stop2);

        assertEquals(1, trip.getStops().size());
    }

    // Test Case 6: Remove a stop not in the list, original stop still present
    // Initial State: stops = [stop1]
    // Action: removeStop(stop2)
    // Expected: assertEquals(1, trip.getStops().size()) and assertTrue(trip.getStops().contains(stop1))
    @Test
    public void testRemoveStopNotInListOriginalIntact()
    {
        Trip trip = new Trip("Test Trip");
        Stop stop1 = new Stop("A", "Park");
        Stop stop2 = new Stop("B", "Museum");

        trip.addStop(stop1);
        trip.removeStop(stop2);

        assertEquals(1, trip.getStops().size());
        assertTrue(trip.getStops().contains(stop1));
    }
}