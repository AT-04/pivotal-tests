package org.fundacionjala.pivotal.core.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.pivotal.core.util.Environment;

/**
 * DockerChromeBrowser class that implements IBrowsers.
 */
public class DockerFirefoxBrowser implements Browser {

    /**
     * Default Constructor.
     */
    public DockerFirefoxBrowser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(Environment.getInstance().getDockerUrl()), firefoxCapabilities);

        } catch (MalformedURLException e) {
            //TODO logger.
        }
        return driver;
    }
}
