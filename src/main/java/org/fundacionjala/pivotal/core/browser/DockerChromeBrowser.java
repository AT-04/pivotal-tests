package org.fundacionjala.pivotal.core.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.pivotal.core.util.Environment;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * DockerChromeBrowser class that implements IBrowsers.
 */
public class DockerChromeBrowser implements Browser {

    private static final Logger LOGGER = LogManager.getLogger();
    /**
     * Default Constructor.
     */
    public DockerChromeBrowser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        Capabilities chromeCapabilities = DesiredCapabilities.chrome();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(Environment.getInstance().getDockerUrl()), chromeCapabilities);

        } catch (MalformedURLException e) {
            LOGGER.error("Not instance driver");
        }
        return driver;
    }
}
