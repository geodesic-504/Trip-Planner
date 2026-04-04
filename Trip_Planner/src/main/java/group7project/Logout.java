package group7project;

public class Logout
{
    public Logout()
    {
        logout();
    }

    public void logout()
    {
        if(Login.verified)
        {
            Login.verified = false;
            System.out.println("You have been logged out");
        }
        else
        {
            System.out.println("No user is currently logged in");
        }
    }
}
