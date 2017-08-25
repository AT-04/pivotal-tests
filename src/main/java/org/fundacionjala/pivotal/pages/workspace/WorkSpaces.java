package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pivotal-test Team.
 */
public class WorkSpaces extends BasePage {

    @FindBy(className = "raw_context_name")
    private WebElement workSpacesName;

    /**
     * This method found the name workspace.
     *
     * @return the text of name project.
     */
    public String workSpacesName() {
        return workSpacesName.getText();
    }

}
