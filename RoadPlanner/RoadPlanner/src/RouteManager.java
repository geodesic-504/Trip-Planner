import java.util.ArrayList;
import java.util.List;

public class RouteManager
{
    //Current Active Route
    private Route activeRoute;

    //Constructor
    public Route calculateRoute(Stop start, Stop end, float distance, float duration)
    {
        Route route = new Route(start, end, distance, duration);

        this.activeRoute = route;

        System.out.println("Route Calculated from : " + start.getName() + " to : " + end.getName());

        return route;
    }

    //Alternative Routes
    public List<Route> getAlternative(Stop start, Stop end, float distance, float duration)
    {
        //Empty List
        List<Route> alternativeRoutes = new ArrayList<>();

        //Fastest Route
        alternativeRoutes.add(new Route(start, end, distance, duration));

        //Shortest Route
        alternativeRoutes.add(new Route(end, start, distance, duration));

        //Scenic Route
        alternativeRoutes.add(new Route(start, end, distance, duration));

        System.out.println("Found " + alternativeRoutes.size() + " alternative routes");

        return  alternativeRoutes;
    }

    public Route getActiveRoute()
    {
        return activeRoute;
    }


}
