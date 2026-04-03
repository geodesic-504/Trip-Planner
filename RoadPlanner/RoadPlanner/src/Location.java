public class Location
{

    private float latitude;
    private float longitude;

    public Location()
    {
        latitude = 0;
        longitude = 0;
    }

    public Location(float la, float lo)
    {
        latitude = la;
        longitude = lo;
    }

    public float getLatitude()
    {
        return latitude;
    }

    public float getLongitude()
    {
        return longitude;
    }

    public void setLatitude(float latitude)
    {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude)
    {
        this.longitude = longitude;
    }

    public float distanceTo(Location l)
    {
        float latdist = latitude - l.getLatitude();
        float longdist = longitude - l.getLongitude();
        return (float) Math.sqrt(latdist*latdist + longdist*longdist);
    }

    public String toString()
    {
        return "Location -> Latitude: " + latitude + "\nLongitude: " + longitude;
    }
}