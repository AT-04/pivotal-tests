package org.fundacionjala.pivotal.pages.dashboard;

import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.project.ProjectList;
import org.fundacionjala.pivotal.utilities.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pivotal-test Team.
 */
public class DashboardMenu extends BasePage {

    @FindBy(className = "tc_projects_menu_show_all")
    private WebElement showAllProjectsButton;

    /**
     * This method perform a click in the Show all Projects Button.
     *
     * @return a ProjectList class instance.
     */
    public ProjectList clickAllProjectsButton() {
        CommonActions.clickButton(showAllProjectsButton);
        return new ProjectList();
    }
}
