package group7project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchService {

    private LocationService locationService;
    private Scanner scanner;

    public SearchService(LocationService locationService, Scanner scanner) {
        this.locationService = locationService;
        this.scanner = scanner;
    }

    // user inputs a query to search for a point of interest
    public List<Stop> searchPOI() {
        System.out.print("Enter place to search for: ");
        String query = scanner.nextLine();
        // takes the search query from the user

        List<Stop> results = new ArrayList<>();
        results.add(new Stop(query + " - Result 1", "poi"));
        results.add(new Stop(query + " - Result 2", "poi"));

        System.out.println("Found " + results.size() + " results for: " + query);
        return results;
    }

    // user inputs an address to convert to a Location
    public Location geocode() {
        System.out.print("Enter address to geocode: ");
        String address = scanner.nextLine();
        // takes the address from the user

        System.out.println("Geocoding address: " + address);

        // placeholder coordinates
        Location location = new Location(53.3498f, -6.2603f);
        System.out.println(location.toString());
        return location;
    }

    // user inputs a query and max distance to search nearby
    public List<Stop> searchNearby() {
        System.out.print("Enter place to search nearby: ");
        String query = scanner.nextLine();
        // takes the search query from the user

        System.out.print("Enter max distance: ");
        float maxDistance = scanner.nextFloat();
        scanner.nextLine();
        // takes the max distance from the user

        List<Stop> nearbyResults = new ArrayList<>();

        Location current = locationService.getCurrentLocation();
        // gets current location from LocationService

        if (current == null) {
            System.out.println("No current location. Please start tracking first.");
            return nearbyResults;
        }

        // placeholder nearby locations
        Location loc1 = new Location(53.3500f, -6.2610f);
        Location loc2 = new Location(53.3600f, -6.2700f);

        // uses distanceTo() from Location.java to check if within range
        if (current.distanceTo(loc1) <= maxDistance) {
            nearbyResults.add(new Stop(query + " - Nearby 1", "poi"));
        }
        if (current.distanceTo(loc2) <= maxDistance) {
            nearbyResults.add(new Stop(query + " - Nearby 2", "poi"));
        }

        System.out.println("Found " + nearbyResults.size() + " nearby results for: " + query);
        return nearbyResults;
    }

    // main menu for search options
    public void run() {
        int choice;

        do {
            System.out.println("\n--- Search Service ---");
            System.out.println("1. Search for a place");
            System.out.println("2. Geocode an address");
            System.out.println("3. Search nearby");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> searchPOI();
                case 2 -> geocode();
                case 3 -> searchNearby();
                case 4 -> System.out.println("Exiting search.");
                default -> System.out.println("Invalid option.");
            }

        } while (choice != 4);
    }
}
