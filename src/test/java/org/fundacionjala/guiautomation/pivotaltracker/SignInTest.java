package org.fundacionjala.guiautomation.pivotaltracker;

import org.fundacionjala.guiautomation.pivotaltracker.pages.signin.SignIn;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by pivotal-test Team.
 */
public class SignInTest {

    /**
     * This test verifies that the user is successfully logged.
     */
    @Test
    public void testLoginSuccessfully() {
        final String username = "learner.mlt@gmail.com";
        final String password = "hellopivotal123";
        final String expectedResult = "Dashboard";
        assertTrue(SignIn.signInAs(username, password).pageTitle().contains(expectedResult));
    }

    /**
     * This test verifies that the user is successfully logged from another page.
     */
    @Test
    public void testLoginSuccessfullyFromAnotherPage() {
        final String username = "marcoslarax86";
        final String password = "hellopivotal123";
        final String expectedResult = "Dashboard";
        SignIn signIn = new SignIn(username, password);
        signIn.navigateTo("https://www.google.com");
        assertTrue(SignIn.signInAs(username, password).pageTitle().contains(expectedResult));
    }

    /**
     * This test verifies that the user is unsuccessfully logged.
     */
    @Test
    public void testLoginUnSuccessfully() {
        final String username = "richard.severich@hotmail.com";
        final String password = "helloword";
        final String expectedResult = "Sign in";
        assertTrue(SignIn.signInAs(username, password).pageTitle().contains(expectedResult));
    }
}
