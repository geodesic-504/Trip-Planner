package group7project;

public class Login
{

    private String username;
    private String password;
    public static Boolean verified = false;
    private int attempts;
    private final static String[][] accounts = {{"edina_o", "edina1234"},
            {"dolphintale12", "iloveoceans!"},
            {"gocomets@utdallas.edu", "temoc1234"}};

    public Login()
    {
        username = null;
        password = null;
        attempts = 0;
    }

    public Login(String u, String p)
    {
        username = u;
        password = p;
        attempts = 0;
    }

    public String verifyInputs()
    {
        for(String[] account: accounts)
        {
            if(attempts == 2){
                return "Max attempts reached, input your email to reset password";
            }
            if(account[0].equals(username))
            {
                if (password.equals(account[1]))
                {
                    verified = true;
                    attempts = 0;
                    return "Login Successful";
                }
            }

        }
        for(String[] account: accounts)
        {
            if(attempts == 3)
            {
                return "Max attempts reached, input your email to reset password";
            }
            if(account[0].equals(username))
            {
                verified = false;
                attempts++;
                return "Password is incorrect, try again";
            }

        }
        attempts++;
        return "Account does not exist";
    }

}