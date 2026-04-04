package group7project;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocationServiceTest {

    @Test
    void testGetCurrentLocationBeforeTracking() {
        LocationService service = new LocationService(5.0f);
        assertNull(service.getCurrentLocation());
    }

    @Test
    void testUpdateLocBeforeTracking() {
        LocationService service = new LocationService(5.0f);
        service.updateLoc(32.9f, -96.7f);
        assertNull(service.getCurrentLocation());
    }

    @Test
    void testUpdateLocAfterTracking() {
        LocationService service = new LocationService(5.0f);
        service.startTracking();
        service.updateLoc(32.9482f, -96.7299f);

        Location loc = service.getCurrentLocation();
        assertNotNull(loc);
        assertEquals(32.9482f, loc.getLatitude(), 0.001f);
        assertEquals(-96.7299f, loc.getLongitude(), 0.001f);
    }

    @Test
    void testGetAccuracy() {
        LocationService service = new LocationService(10.0f);
        assertEquals(10.0f, service.getAccuracy(), 0.001f);
    }

    @Test
    void testSetAccuracy() {
        LocationService service = new LocationService(10.0f);
        service.setAccuracy(2.5f);
        assertEquals(2.5f, service.getAccuracy(), 0.001f);
    }
}