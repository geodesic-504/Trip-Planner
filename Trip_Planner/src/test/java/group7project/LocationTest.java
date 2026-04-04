package group7project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    @Test
    void testDistanceSameLocation() {
        Location loc = new Location(32.9f, -96.7f);
        assertEquals(0.0f, loc.distanceTo(loc), 0.001f);
    }

    @Test
    void testDistancePythagorean() {
        Location a = new Location(0f, 0f);
        Location b = new Location(3f, 4f);
        assertEquals(5.0f, a.distanceTo(b), 0.001f);
    }

    @Test
    void testDistanceSymmetry() {
        Location a = new Location(10f, 20f);
        Location b = new Location(30f, 50f);
        assertEquals(a.distanceTo(b), b.distanceTo(a), 0.001f);
    }

    @Test
    void testLocationConstructorGetters() {
        Location loc = new Location(33.0198f, -96.6989f);
        assertEquals(33.0198f, loc.getLatitude(), 0.0001f);
        assertEquals(-96.6989f, loc.getLongitude(), 0.0001f);
    }

    @Test
    void testLocationSetters() {
        Location loc = new Location(0f, 0f);
        loc.setLatitude(54.0f);
        loc.setLongitude(-7.0f);
        assertEquals(54.0f, loc.getLatitude(), 0.0001f);
        assertEquals(-7.0f, loc.getLongitude(), 0.0001f);
    }
}