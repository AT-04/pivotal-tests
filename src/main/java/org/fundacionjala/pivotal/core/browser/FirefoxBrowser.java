package org.fundacionjala.pivotal.core.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by pivotal-test Team.
 */
public class FirefoxBrowser implements Browser {

    private static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
    private static final String FIREFOX_DRIVER_PATH = "drivers/geckodriver.exe";

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_PATH);
        return new FirefoxDriver();
    }
}
