package group7project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogoutTest
{
    @BeforeEach
    public void setUp()
    {
        Login.verified = false;
    }

    // Test Case 1: Logout when a user is logged in
    // Expected Result: Login.verified is false
    @Test
    public void testLogoutWhenLoggedIn()
    {
        Login.verified = true;

        Logout logout = new Logout();

        assertFalse(Login.verified);
    }

    // Test Case 2: Logout when no user is logged in
    // Expected Result: login.verified stays false
    @Test
    public void testLogoutWhenAlreadyLoggedOut()
    {
        Login.verified = false;

        Logout logout = new Logout();

        assertFalse(Login.verified);
    }

    // Test Case 3: Logout twice in a row
    // Expected Result: login.verified stays false after being set to false from
    // the first logout
    @Test
    public void testLogoutTwiceInARow()
    {
        Login.verified = true;

        Logout firstLogout = new Logout();
        assertFalse(Login.verified); // first logout succeeded

        Logout secondLogout = new Logout();
        assertFalse(Login.verified); // second logout: no user logged in, stays false
    }
}