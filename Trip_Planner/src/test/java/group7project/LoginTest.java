package group7project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest
{
    @BeforeEach
    public void setUp()
    {
        Login.verified = false;
    }

    // Test Case 1: Valid username and valid password
    // Expected Result: Login Successful
    @Test
    public void testValidLogin()
    {
        Login login = new Login();
        login = new Login("edina_o", "edina1234");

        String result = login.verifyInputs();

        assertEquals("Login Successful", result);
        assertTrue(Login.verified);
    }

    // Test Case 2: Valid username, invalid password
    // Expected result: Password is incorrect, try again
    @Test
    public void testWrongPassword()
    {
        Login login = new Login("edina_o", "gdsag123");

        String result = login.verifyInputs();

        assertEquals("Password is incorrect, try again", result);
        assertFalse(Login.verified);
    }

    // Test Case 3: Invalid username, valid password
    // Expected Result: Account does not exist
    @Test
    public void testAccountDoesNotExist()
    {
        Login login = new Login("hdsad123", "edina1234");

        String result = login.verifyInputs();

        assertEquals("Account does not exist", result);
        assertFalse(Login.verified);
    }

    // Test Case 4: Exceptional username with space and uncommon special character, valid password
    // Expected result: Account does not exist
    @Test
    public void testUsernameWithSpecialAndSpace()
    {
        Login login = new Login("abcd ©123", "edina1234");

        String result = login.verifyInputs();
        assertEquals("Account does not exist", result);
        assertFalse(Login.verified);
    }

    // Test Case 5: Valid Username, exceptional password with space and uncommon special character
    // Expected Result: Password is incorrect, try again
    @Test
    public void TestPasswordWithSpecialAndSpace() {
        Login login = new Login("edina_o", "fdsa ©123");

        String result = login.verifyInputs();

        assertEquals("Password is incorrect, try again", result);
        assertFalse(Login.verified);
    }
}