package group7project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RouteTest {

    private Stop startStop;
    private Stop endStop;
    private RouteManager routeManager;

    @BeforeEach
    void setUp() {
        startStop = new Stop("UTD Campus", "university");
        endStop = new Stop("DFW Airport", "airport");
        routeManager = new RouteManager();
    }

    @Test
    void testCalculateRouteNotNull() {
        Route route = routeManager.calculateRoute(startStop, endStop, 50f, 45f);
        assertNotNull(route);
    }

    @Test
    void testActiveRouteIsSet() {
        Route route = routeManager.calculateRoute(startStop, endStop, 50f, 45f);
        assertSame(route, routeManager.getActiveRoute());
    }

    @Test
    void testAlternativeRouteCount() {
        List<Route> alts = routeManager.getAlternative(startStop, endStop, 50f, 45f);
        assertNotNull(alts);
        assertEquals(3, alts.size());
    }

    @Test
    void testRouteNotCompleteOnCreation() {
        Route route = new Route(startStop, endStop, 10f, 20f);
        assertFalse(route.isComplete());
    }

    @Test
    void testRouteDistanceAndDurationPositive() {
        Route route = new Route(startStop, endStop, 10f, 20f);
        assertTrue(route.getDistance() > 0f);
        assertTrue(route.getDuration() > 0f);
    }

    @Test
    void testGetNextStepInstruction() {
        Route route = new Route(startStop, endStop, 10f, 20f);
        Step step = route.getNextStep();
        assertNotNull(step);
        assertNotNull(step.getInstruction());
        assertFalse(step.getInstruction().isEmpty());
    }

    @Test
    void testStepDistanceRange() {
        Route route = new Route(startStop, endStop, 10f, 20f);
        Step step = route.getNextStep();
        assertTrue(step.getDistance() > 0f);
        assertTrue(step.getDistance() <= 5.0f);
    }

    @Test
    void testMultipleNextStepsAllNonNull() {
        Route route = new Route(startStop, endStop, 10f, 20f);
        for (int i = 0; i < 5; i++) {
            Step step = route.getNextStep();
            assertNotNull(step);
        }
    }
}