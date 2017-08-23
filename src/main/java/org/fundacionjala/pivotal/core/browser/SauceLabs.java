package org.fundacionjala.pivotal.core.browser;

import org.fundacionjala.pivotal.core.util.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * SauceLabs class that implements IBrowsers.
 */
public class SauceLabs implements Browser {
  private static final Environment ENV = Environment.getInstance();

  private static final String USERNAME = ENV.getRemoteUserName();
  private static final String ACCESS_KEY = ENV.getRemoteKey();
  private static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
  private static final String PLATFORM = "platform";
  private static final String RESOLUTION = "resolution";
  private static final Logger LOGGER = LogManager.getLogger();

  /**
   * This method save all capabilities.
   *
   * @return setting capabilities SauceLabs.
   */
  private DesiredCapabilities setCapabilities() {
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    caps.setCapability(PLATFORM, String.format("%s %s",
        ENV.getRemotePlatform(),
        ENV.getRemotePlatformVersion()));
    caps.setCapability(RESOLUTION, ENV.getRemoteResolution());
    return caps;
  }

  /**
   * This method override get browser.
   *
   * @return Driver.
   */
  @Override
  public WebDriver getBrowser() {
    WebDriver driver;
    try {
      driver = new RemoteWebDriver(new URL(URL), setCapabilities());
    } catch (MalformedURLException e) {
      LOGGER.error("Not instance driver");
      throw new RuntimeException();
    }
    return driver;
  }
}
