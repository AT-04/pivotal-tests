package org.fundacionjala.guiautomation.pivotaltracker.pages;

import org.fundacionjala.guiautomation.pivotaltracker.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by pivotal-test Team.
 */
public abstract class BasePage {

    protected WebDriver webDriver;

    /**
     * This method is the constructor class.
     */
    public BasePage() {
        webDriver = DriverManager.getInstance().getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

    /**
     * This method get title of current page.
     *
     * @return title of the current page.
     */
    public String pageTitle() {
        return webDriver.getTitle();
    }

    /**
     * This method get url page.
     *
     * @param shortUrl url page.
     */
    public void loadUrlPage(String shortUrl) {
        String longUrl = String.join("", DriverManager.getInstance().getBaseUrl(), shortUrl);
        webDriver.get(longUrl);
    }

    /**
     * This method navigate to a specific url.
     *
     * @param url Is the address of the web.
     */
    public void navigateTo(String url) {
        webDriver.navigate().to(url);
    }
}
