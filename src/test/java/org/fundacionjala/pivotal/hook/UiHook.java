package org.fundacionjala.pivotal.hook;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.fundacionjala.pivotal.core.browser.DriverManager;
import org.fundacionjala.pivotal.core.util.Navigator;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Created by pivotal-test Team.
 */
public class UiHook {

    private Helper helper;

    /**
     * Api Hook constructor using Dependency Injection.
     *
     * @param helper object utility instance.
     */
    public UiHook(Helper helper) {
        this.helper = helper;
    }

    /**
     * Hook for delete the created account for the UI tests.
     */
    @After("@DeleteAccount")
    public void deleteAccount() {
        Navigator.loadDashboardPage().clickAccountListItem().deleteAccount(helper.getAccountVariable());
    }

    /**
     * Takes a snapshot when a scenario fails.
     *
     * @param scenario variable for Cucumber features.
     */
    @After
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
    }
}
