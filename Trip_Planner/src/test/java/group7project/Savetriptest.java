package group7project;

import java.util.ArrayList;
import java.util.List;

public class Savetriptest
{
    private String tripName;
    private List<Stop> stops;
    private Route route;
    private boolean saved;

    public Savetriptest(String tripName)
    {
        this.tripName = tripName;
        this.stops = new ArrayList<>();
        this.route = null;
        this.saved = false;
    }

    public Savetriptest(String tripName, List<Stop> stops, Route route)
    {
        this.tripName = tripName;
        this.stops = new ArrayList<>(stops);
        this.route = route;
        this.saved = false;
    }

    public void addStop(Stop stop)
    {
        stops.add(stop);
    }

    public void removeStop(Stop stop)
    {
        stops.remove(stop);
    }

    public String getTripName()
    {
        return tripName;
    }

    public List<Stop> getStops()
    {
        return stops;
    }

    public Route getRoute()
    {
        return route;
    }

    public void setRoute(Route route)
    {
        this.route = route;
    }

    public boolean isSaved()
    {
        return saved;
    }

    public void setSaved(boolean saved)
    {
        this.saved = saved;
    }

    public String getDetails()
    {
        return "Trip: " + tripName + " | Stops: " + stops.size() + " | Saved: " + saved;
    }
}
