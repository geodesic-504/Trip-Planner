package group7project;

public class Step
{
    //Implements variables needed in Class
    private String instruction;
    private float distance;

    //Constructors
    public Step(String instruction, float distance)
    {
        this.instruction = instruction;
        this.distance = distance;
    }

    //Printing the instructions
    public void printStep()
    {
        System.out.println("Step: " + instruction + " in " + distance + " in miles");
    }

    //Getters
    public String getInstruction()
    {
        return instruction;
    }

    public float getDistance()
    {
        return distance;
    }
}
