package org.fundacionjala.pivotal.pages;

import org.fundacionjala.pivotal.browser.DriverManager;
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
}
