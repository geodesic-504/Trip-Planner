public class Stop
{
    //Implement Variables for Classes
    private String name;
    private String type;


    //Constructor
    public Stop(String name, String type)
    {
        this.name = name;
        this.type = type;
    }

    //Getting the details of the Stop
    public String getDetails()
    {
        return ("Stop: " + name + " | Type:  " + type);
    }

    //Getter
    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }
}
