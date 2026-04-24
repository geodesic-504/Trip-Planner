package group7project;

import java.util.ArrayList;
import java.util.List;

public class TripManager
{
    private List<Trip> savedTrips;

    public TripManager()
    {
        this.savedTrips = new ArrayList<>();
    }

    public boolean saveTrip(Trip trip)
    {
        if (trip == null)
        {
            System.out.println("Cannot save a null trip.");
            return false;
        }

        if (trip.getTripName() == null || trip.getTripName().trim().isEmpty())
        {
            System.out.println("Trip must have a name to be saved.");
            return false;
        }

        for (Trip t : savedTrips)
        {
            if (t.getTripName().equals(trip.getTripName()))
            {
                System.out.println("A trip with this name already exists.");
                return false;
            }
        }

        trip.setSaved(true);
        savedTrips.add(trip);
        System.out.println("Trip saved: " + trip.getTripName());
        return true;
    }

    public Trip getTrip(String tripName)
    {
        for (Trip t : savedTrips)
        {
            if (t.getTripName().equals(tripName))
            {
                return t;
            }
        }
        System.out.println("Trip not found: " + tripName);
        return null;
    }

    public List<Trip> getAllTrips()
    {
        return savedTrips;
    }

    public boolean deleteTrip(String tripName)
    {
        Trip toRemove = getTrip(tripName);
        if (toRemove != null)
        {
            savedTrips.remove(toRemove);
            System.out.println("Trip deleted: " + tripName);
            return true;
        }
        return false;
    }

    public int getTripCount()
    {
        return savedTrips.size();
    }
}