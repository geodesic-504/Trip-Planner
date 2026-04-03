import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // =====================
        // LOCATION TEST
        // =====================
        System.out.println("--- Location ---");

        System.out.print("Enter latitude: ");
        float lat = scanner.nextFloat();

        System.out.print("Enter longitude: ");
        float lon = scanner.nextFloat();
        scanner.nextLine();

        Location location1 = new Location(lat, lon);
        // tests the constructor with inputs

        System.out.println(location1.toString());
        // tests toString()

        System.out.print("Enter second latitude: ");
        float lat2 = scanner.nextFloat();

        System.out.print("Enter second longitude: ");
        float lon2 = scanner.nextFloat();
        scanner.nextLine();

        Location location2 = new Location(lat2, lon2);
        System.out.println(location2.toString());

        System.out.println("Distance between locations: " + location1.distanceTo(location2));
        // tests distanceTo()

        // tests setters
        location1.setLatitude(54.0f);
        location1.setLongitude(-7.0f);
        System.out.println("Updated location1: " + location1.toString());
        // tests setLatitude() and setLongitude()

        // =====================
        // LOCATION SERVICE TEST
        // =====================
        System.out.println("\n--- Location Service ---");

        System.out.print("Enter accuracy: ");
        float accuracy = scanner.nextFloat();
        scanner.nextLine();

        LocationService locationService = new LocationService(accuracy);
        // tests constructor

        System.out.println("Accuracy: " + locationService.getAccuracy());
        // tests getAccuracy()

        System.out.println("Current location before tracking: " + locationService.getCurrentLocation());
        // tests getCurrentLocation() when null

        locationService.updateLoc(lat, lon);
        // tests updateLoc() when tracking is off

        locationService.startTracking();
        // tests startTracking()

        System.out.println("Tracking started.");

        locationService.updateLoc(lat, lon);
        // tests updateLoc() when tracking is on

        System.out.println("Current location after tracking: " + locationService.getCurrentLocation());
        // tests getCurrentLocation() after update

        locationService.setAccuracy(5.0f);
        System.out.println("Updated accuracy: " + locationService.getAccuracy());
        // tests setAccuracy()

        // =====================
        // STOP TEST
        // =====================
        System.out.println("\n--- Stop ---");

        System.out.print("Enter start stop name: ");
        String startName = scanner.nextLine();

        System.out.print("Enter start stop type: ");
        String startType = scanner.nextLine();

        Stop start = new Stop(startName, startType);
        // tests Stop constructor

        System.out.println(start.getDetails());
        // tests getDetails()

        System.out.println("Name: " + start.getName());
        // tests getName()

        System.out.println("Type: " + start.getType());
        // tests getType()

        System.out.print("Enter end stop name: ");
        String endName = scanner.nextLine();

        System.out.print("Enter end stop type: ");
        String endType = scanner.nextLine();

        Stop end = new Stop(endName, endType);
        System.out.println(end.getDetails());

        // =====================
        // ROUTE TEST
        // =====================
        System.out.println("\n--- Route ---");

        System.out.print("Enter distance (km): ");
        float distance = scanner.nextFloat();

        System.out.print("Enter duration (mins): ");
        float duration = scanner.nextFloat();
        scanner.nextLine();

        Route route = new Route(start, end, distance, duration);
        // tests Route constructor

        System.out.println("Distance: " + route.getDistance());
        // tests getDistance()

        System.out.println("Duration: " + route.getDuration());
        // tests getDuration()

        System.out.println("Start: " + route.getStart().getName());
        // tests getStart()

        System.out.println("End: " + route.getEnd().getName());
        // tests getEnd()

        System.out.println("Route complete? " + route.isComplete());
        // tests isComplete()

        Step step = route.getNextStep();
        step.printStep();
        // tests getNextStep() and printStep()

        // =====================
        // ROUTE MANAGER TEST
        // =====================
        System.out.println("\n--- Route Manager ---");

        RouteManager routeManager = new RouteManager();

        Route calculated = routeManager.calculateRoute(start, end, distance, duration);
        // tests calculateRoute()

        System.out.println("Active route start: " + routeManager.getActiveRoute().getStart().getName());
        System.out.println("Active route end: "   + routeManager.getActiveRoute().getEnd().getName());
        // tests getActiveRoute()

        List<Route> alternatives = routeManager.getAlternative(start, end, distance, duration);
        System.out.println("Number of alternatives: " + alternatives.size());
        // tests getAlternatives()

        // =====================
        // SEARCH SERVICE TEST
        // =====================
        System.out.println("\n--- Search Service ---");

        SearchService searchService = new SearchService(locationService);

        System.out.println("Testing searchPOI:");
        List<Stop> poi = searchService.searchPOI();
        // tests searchPOI() with user input

        System.out.println("Testing geocode:");
        Location geocoded = searchService.geocode();
        System.out.println(geocoded.toString());
        // tests geocode() with user input

        System.out.println("Testing searchNearby:");
        List<Stop> nearby = searchService.searchNearby();
        // tests searchNearby() with user input

        System.out.println("\n--- All methods tested successfully ---");

        scanner.close();
    }
}