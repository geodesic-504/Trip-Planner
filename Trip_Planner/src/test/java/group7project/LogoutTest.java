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

        new Logout();

        assertFalse(Login.verified);
    }

    // Test Case 2: Logout when no user is logged in
    // Expected Result: login.verified stays false
    @Test
    public void testLogoutWhenAlreadyLoggedOut()
    {
        Login.verified = false;

        new Logout();

        assertFalse(Login.verified);
    }

    // Test Case 3: login.verified is null
    // Expected Result: Null Pointer Exception is thrown
    @Test
    public void testLogoutWhenVerifiedIsNull()
    {
        Login.verified = null;

        assertThrows(NullPointerException.class, () -> {
            new Logout();
        });
    }
}
