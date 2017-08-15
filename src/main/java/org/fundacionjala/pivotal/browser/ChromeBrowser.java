package org.fundacionjala.pivotal.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by pivotal-test Team.
 */
public class ChromeBrowser implements Browser {

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "drivers/chromedriver.exe";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        return new ChromeDriver();
    }
}
