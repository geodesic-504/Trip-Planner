package group7project;

import java.util.Random;

public class Route
{
    //Variables for Class Purposes
    private float distance;
    private float duration;
    private Stop start;
    private Stop end;

    //Constructor
    public Route(Stop s1, Stop s2, float distance, float duration)
    {
        this.start = start;
        this.end = end;


        //Random Simulation
        Random rand = new Random();
        this.distance = 1 + rand.nextFloat() * 49;
        this.duration = 1 + rand.nextFloat() * 49;

    }

    //Checks if complete
    public boolean isComplete()
    {
        //Check if there is no distance is left
        return  distance == 0;
    }

    //Gets the next step
    public Step getNextStep()
    {
        Random rand = new Random();
        String[] instructions =
                {
                        "Turn left at junction",
                        "Turn right at traffic lights",
                        "Continue straight for 2 mi",
                        "Take the motorway exit",
                        "Merge onto the highway"
                };
        String instruction = instructions[rand.nextInt(instructions.length)];
        float stepDistance = 0.1f + rand.nextFloat() * 4.9f; // 0.1 - 5 km
        return new Step(instruction, stepDistance);
    }


    //Getters
    public float getDistance()
    {
        return distance;
    }
    public float  getDuration()
    {
        return duration;
    }
    public Stop getStart()
    {
        return start;
    }
    public Stop getEnd()
    {
        return end;
    }
}
