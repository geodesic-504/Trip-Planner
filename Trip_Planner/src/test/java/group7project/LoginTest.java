package group7project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Login login = new Login("edina_o", "edina1234");

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

    // Test Case 4: Exceptionally long string for username
    // Expected Result: Account does not exist
    @Test
    public void testUsernameWithSpecialAndSpace()
    {
        String largeInput = "a".repeat(10000);
        Login login = new Login(largeInput, "edina1234");

        String result = login.verifyInputs();
        assertEquals("Account does not exist", result);
        assertFalse(Login.verified);
    }

    // Test Case 5: Exceptionally long string for password
    // Expected Result: Password is incorrect, try again
    @Test
    public void TestPasswordWithSpecialAndSpace() {
        String largeInput = "a".repeat(10000);

        Login login = new Login("edina_o", largeInput);

        String result = login.verifyInputs();

        assertEquals("Password is incorrect, try again", result);
        assertFalse(Login.verified);
    }
}