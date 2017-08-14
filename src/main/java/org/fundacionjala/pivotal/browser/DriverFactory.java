package org.fundacionjala.pivotal.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by pivotal-test Team.
 */
public final class DriverFactory {

    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "drivers/chromedriver.exe";
    private static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
    private static final String FIREFOX_DRIVER_PATH = "drivers/geckodriver.exe";

    /**
     * Private Constructor for the DriverFactory utility class.
     */
    private DriverFactory() {
    }

    /**
     * Return the WebDriver instance specified by the environment properties.
     *
     * @param driverType Enum value specified from DriverType.
     * @return a WebDriver instance.
     */
    public static WebDriver getDriverManager(DriverType driverType) {
        switch (driverType) {
            case FIREFOX:
                System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_PATH);
                return new FirefoxDriver();
            default:
                System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
                return new ChromeDriver();
        }
    }
}
