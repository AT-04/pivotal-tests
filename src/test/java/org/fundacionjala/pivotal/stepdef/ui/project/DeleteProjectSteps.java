package org.fundacionjala.pivotal.stepdef.ui.project;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.ProjectSettingsForm;
import org.fundacionjala.pivotal.utilities.DataBuilder;
import org.fundacionjala.pivotal.utilities.Helper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by pivotal-test Team.
 */
public class DeleteProjectSteps {

    private Dashboard dashboard;
    private ProjectSettingsForm projectSettingsForm;
    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param dashboard is the dashboard instance.
     * @param helper    is the helper utility class instance.
     */
    public DeleteProjectSteps(Dashboard dashboard, Helper helper) {
        this.dashboard = dashboard;
        this.helper = helper;
    }

    /**
     * Step definition that perform the click on settings project icon.
     *
     * @param data is the data to be entered.
     */
    @When("^the user enters to \"([^\"]*)\" settings page$")
    public void theUserEntersToSettingsPage(String data) {
        helper.setProjectVariable(DataBuilder.getSingleValue(data).toString());
        projectSettingsForm = dashboard.clickProjectConfig(helper.getProjectVariable());
    }

    /**
     * Step definition that perform the project deletion.
     */
    @And("^delete the Project$")
    public void deleteTheProject() {
        dashboard = projectSettingsForm.deleteProject();
    }

    /**
     * Step definition that perform the assertion in the notice dashboard page.
     *
     * @param message the message content.
     */
    @Then("^message \"([^\"]*)\" should appear$")
    public void messageShouldAppear(String message) {
        assertTrue(DataBuilder.rebuildMessage(message).equals(dashboard.getNoticeText()));
    }

    /**
     * Step definition that perform the assertion in the dashboard page.
     *
     * @param attribute the project name.
     */
    @And("^the \"([^\"]*)\" is not displayed in Dashboard$")
    public void theIsNotDisplayedInDashboard(String attribute) {
        assertFalse(dashboard.isProjectFound(DataBuilder.getSingleValue(attribute).toString()));
    }
}
