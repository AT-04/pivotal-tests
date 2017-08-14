package org.fundacionjala.pivotal.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.fundacionjala.pivotal.browser.DriverManager;
import org.testng.annotations.AfterTest;

/**
 * Created by pivotal-test Team.
 */
@CucumberOptions(
        plugin = {"pretty"},
        features = {"src/test/resources/features"},
        glue = {"org.fundacionjala.pivotal"})

public class Runner extends AbstractTestNGCucumberTests {

    /**
     * This method close the web driver after the all feature test execution.
     */
    @AfterTest
    public void closeBrowser() {
        DriverManager.getInstance().getWebDriver().quit();
    }
}
