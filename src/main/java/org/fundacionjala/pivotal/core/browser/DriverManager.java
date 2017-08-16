package org.fundacionjala.pivotal.core.browser;

import org.fundacionjala.pivotal.core.util.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by pivotal-test Team.
 */
public final class DriverManager {

    private static final String BASE_URL = "https://www.pivotaltracker.com";

    private static DriverManager instance;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * This method is the constructor class.
     */
    private DriverManager() {
        DriverType driverType = DriverType.valueOf(Environment.getInstance().getBrowser());
        webDriver = DriverFactory.getDriverManager(driverType);
        restorePreviousTimeWait();
    }

    /**
     * This method instance the singleton object.
     *
     * @return singleton instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * This method return the base url.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * This method return the web driver.
     *
     * @return web driver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * This method return the web Driver Wait.
     *
     * @return Web Driver Wait.
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    /**
     * This method sets implicit time wait.
     *
     * @param implicitTimeWait is implicit time wait.
     */
    public void setImplicitTimeWait(int implicitTimeWait) {
        webDriver.manage().timeouts().implicitlyWait(implicitTimeWait, TimeUnit.SECONDS);
    }

    /**
     * This method sets explicit time wait.
     *
     * @param explicitTimeWait is explicit time wait.
     */
    public void setExplicitTimeWait(int explicitTimeWait) {
        webDriverWait = new WebDriverWait(webDriver, explicitTimeWait);
    }

    /**
     * This method updates explicit and implicit time wait.
     *
     * @param time is the time wait.
     */
    public void updateTimeWait(int time) {
        setImplicitTimeWait(time);
        setExplicitTimeWait(time);
    }

    /**
     * This method back previous wait.
     */
    public void restorePreviousTimeWait() {
        final int implicitTimeWait = 15;
        final int explicitTimeWait = 30;
        setImplicitTimeWait(implicitTimeWait);
        setExplicitTimeWait(explicitTimeWait);
    }
}
