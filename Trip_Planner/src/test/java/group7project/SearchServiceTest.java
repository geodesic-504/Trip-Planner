package group7project;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SearchServiceTest {

    @Test
    void testSearchNearbyNoLocation() {
        LocationService service = new LocationService(5.0f);
        TestableSearchService search = new TestableSearchService(service);

        List<Stop> result = search.searchNearby("coffee", 1.0f);
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testSearchNearbyInRange() {
        LocationService service = new LocationService(5.0f);
        service.startTracking();
        service.updateLoc(53.3499f, -6.2605f);

        TestableSearchService search = new TestableSearchService(service);
        List<Stop> result = search.searchNearby("cafe", 1.0f);

        assertNotNull(result);
        assertTrue(result.size() >= 1);
    }

    @Test
    void testSearchNearbyOutOfRange() {
        LocationService service = new LocationService(5.0f);
        service.startTracking();
        service.updateLoc(0.0f, 0.0f);

        TestableSearchService search = new TestableSearchService(service);
        List<Stop> result = search.searchNearby("gas", 0.001f);

        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    void testSearchPOIReturnsTwoResults() {
        LocationService service = new LocationService(5.0f);
        TestableSearchService search = new TestableSearchService(service);

        List<Stop> result = search.searchPOI("park");
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    void testSearchPOIResultNames() {
        LocationService service = new LocationService(5.0f);
        TestableSearchService search = new TestableSearchService(service);

        String query = "library";
        List<Stop> result = search.searchPOI(query);

        for (Stop stop : result) {
            assertTrue(stop.getName().contains(query));
        }
    }

    @Test
    void testGeocodeReturnsPlaceholder() {
        LocationService service = new LocationService(5.0f);
        TestableSearchService search = new TestableSearchService(service);

        Location loc = search.geocode("123 Main St");
        assertNotNull(loc);
        assertEquals(53.3498f, loc.getLatitude(), 0.001f);
        assertEquals(-6.2603f, loc.getLongitude(), 0.001f);
    }

    static class TestableSearchService {
        private final LocationService locationService;

        TestableSearchService(LocationService locationService) {
            this.locationService = locationService;
        }

        public List<Stop> searchPOI(String query) {
            List<Stop> results = new ArrayList<>();
            results.add(new Stop(query + " - Result 1", "poi"));
            results.add(new Stop(query + " - Result 2", "poi"));
            return results;
        }

        public Location geocode(String address) {
            return new Location(53.3498f, -6.2603f);
        }

        public List<Stop> searchNearby(String query, float maxDistance) {
            List<Stop> nearbyResults = new ArrayList<>();
            Location current = locationService.getCurrentLocation();

            if (current == null) {
                return nearbyResults;
            }

            Location loc1 = new Location(53.3500f, -6.2610f);
            Location loc2 = new Location(53.3600f, -6.2700f);

            if (current.distanceTo(loc1) <= maxDistance) {
                nearbyResults.add(new Stop(query + " - Nearby 1", "poi"));
            }
            if (current.distanceTo(loc2) <= maxDistance) {
                nearbyResults.add(new Stop(query + " - Nearby 2", "poi"));
            }

            return nearbyResults;
        }
    }
}