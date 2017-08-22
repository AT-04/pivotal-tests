package org.fundacionjala.pivotal.core.browser;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pivotal-test Team.
 */
public final class DriverFactory {


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
        Map<DriverType, Browser> map = new HashMap<>();
        map.put(DriverType.CHROME, new ChromeBrowser());
        map.put(DriverType.FIREFOX, new FirefoxBrowser());
        map.put(DriverType.BROWSERSTACK, new BrowserStack());
        map.put(DriverType.SAUCELABS, new SauceLabs());
        return map.get(driverType).getBrowser();
    }
}
