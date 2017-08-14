package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pivotal-test Team.
 */
public class Project extends BasePage {

    @FindBy(className = "raw_context_name")
    private WebElement projectName;

    @FindBy(css = "a[class='button add_story'] > span[class='icon']")
    private WebElement addStoryButton;


    /**
     * This method return the Project name label value of the Project page.
     *
     * @return the text value of the Project name label.
     */
    public String projectName() {
        return projectName.getText();
    }
}
