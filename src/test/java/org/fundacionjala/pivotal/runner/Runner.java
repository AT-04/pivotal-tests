package org.fundacionjala.pivotal.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.fundacionjala.pivotal.browser.DriverManager;
import org.fundacionjala.pivotal.pages.signin.SignIn;
import org.fundacionjala.pivotal.utilities.Environment;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by pivotal-test Team.
 */
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features"},
        glue = {"org.fundacionjala.pivotal"})

public class Runner extends AbstractTestNGCucumberTests {

    /**
     * This method perform the smart login process.
     */
    @BeforeTest
    public void login() {
        SignIn.signInAs(Environment.getInstance().getUser(), Environment.getInstance().getPassword());
    }

    /**
     * This method close the web driver after the all feature test execution.
     */
    @AfterTest
    public void closeBrowser() {
        DriverManager.getInstance().getWebDriver().quit();
    }
}
