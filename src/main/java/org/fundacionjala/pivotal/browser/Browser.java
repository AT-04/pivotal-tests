package org.fundacionjala.pivotal.browser;

import org.openqa.selenium.WebDriver;

/**
 * Created by pivotal-test Team.
 */
public interface Browser {

    /**
     * This method return a Web Driver instance of a specified browser.
     *
     * @return the Web Driver instance.
     */
    WebDriver getBrowser();
}
