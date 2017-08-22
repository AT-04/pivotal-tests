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
public class DockerChromeBrowser implements Browser {

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
            //TODO logger.
        }
        return driver;
    }
}
