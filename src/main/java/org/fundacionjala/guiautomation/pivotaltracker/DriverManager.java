package org.fundacionjala.guiautomation.pivotaltracker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by pivotal-test Team.
 */
public final class DriverManager {
    private static final String BASE_URL = "https://www.pivotaltracker.com";
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROME_DRIVER_PATH = "drivers/chromedriver.exe";

    private static DriverManager instance;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * This method is the class constructor.
     */
    private DriverManager() {
        System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
        webDriver = new ChromeDriver();
        backPreviousWait();
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
     * This method  return the base url.
     *
     * @return base url.
     */
    public String getBaseUrl() {
        return BASE_URL;
    }

    /**
     * This method return web driver.
     *
     * @return web driver.
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * This method return web Driver Wait.
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
     * This method update explicit and implicit time wait.
     *
     * @param time it time wait.
     */
    public void setUpdateWait(int time) {
        setImplicitTimeWait(time);
        setExplicitTimeWait(time);
    }

    /**
     * This method back previous wait.
     */
    public void backPreviousWait() {
        final int implicitTimeWait = 15;
        final int explicitTimeWait = 30;
        setImplicitTimeWait(implicitTimeWait);
        setExplicitTimeWait(explicitTimeWait);
    }
}
