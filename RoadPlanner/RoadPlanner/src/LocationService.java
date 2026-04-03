public class LocationService
{

    private float accuracy;
    private Location currentLoc;
    private boolean tracking;

    public LocationService(float a)
    {
        accuracy = a;
        currentLoc = null;
        tracking = false;
    }

    public void setAccuracy(float accuracy)
    {
        this.accuracy = accuracy;
    }

    public float getAccuracy()
    {
        return accuracy;
    }


    public Location getCurrentLocation()
    {
        return currentLoc;
    }

    public void startTracking()
    {
        tracking = true;
    }

    public void updateLoc(float lat, float lon)
    {
        if(!tracking){
            System.out.println("Tracking is not on; unable to get update location.");
        }
        else
            currentLoc = new Location(lat, lon);
    }

}