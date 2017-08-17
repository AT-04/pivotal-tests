package org.fundacionjala.pivotal.stepdef.ui.project;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.project.ProjectSettingsForm;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by pivotal-test Team.
 */
public class AssertProjectSteps {

    private Dashboard dashboard;
    private Project project;
    private ProjectSettingsForm projectSettingsForm;
    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param dashboard           is the dashboard class instance.
     * @param project             is the project class instance.
     * @param helper              is the helper utility class instance.
     * @param projectSettingsForm is the project settings form instance.
     */
    public AssertProjectSteps(Dashboard dashboard, Project project,
                              Helper helper, ProjectSettingsForm projectSettingsForm) {
        this.dashboard = dashboard;
        this.project = project;
        this.projectSettingsForm = projectSettingsForm;
        this.helper = helper;
    }

    /**
     * Step definition that perform the assertion in the project main page.
     */
    @Then("^new project name is displayed in the project main page$")
    public void newProjectNameIsDisplayedInTheProjectMainPage() {
        assertTrue(project.projectName().contains(helper.getProjectVariable()));
    }

    /**
     * * Step definition that perform the assertion in the dashboard page.
     */
    @Then("^project is displayed in the dashboard$")
    public void newProjectNameIsDisplayedInTheDashboard() {
        assertTrue(dashboard.isProjectFound(helper.getProjectVariable()));
    }

    /**
     * Step definition that perform the assertion in the notice dashboard page.
     *
     * @param message the message content.
     */
    @Then("^message \"([^\"]*)\" should be displayed$")
    public void messageShouldAppear(String message) {
        assertTrue(DataInterpreter.rebuiltMessage(message).equals(dashboard.getNoticeText()));
    }

    /**
     * Step definition that perform the assertion in the dashboard page.
     *
     * @param attribute the project name.
     */
    @And("^the \"([^\"]*)\" is not displayed in Dashboard$")
    public void theIsNotDisplayedInDashboard(String attribute) {
        assertFalse(dashboard.isProjectFound(DataInterpreter.getValue(attribute).toString()));
    }

    /**
     * Step definition that perform the assertion in the settings page.
     *
     * @param message the message that should appear.
     */
    @Then("^message \"([^\"]*)\" should appear in settings page$")
    public void messageShouldAppearInSettingsPage(String message) {
        assertTrue(projectSettingsForm.getChangesSuccessText().equals(message));
    }

    /**
     * Step definition that perform the assertion in the dashboard page.
     *
     * @param name is the old project name.
     */
    @Then("^\"([^\"]*)\" is not displayed in dashboard$")
    public void isNotDisplayedInDashboard(String name) {
        assertFalse(dashboard.isProjectFound(DataInterpreter.getValue(name).toString()));
    }

    /**
     * Step definition that perform the assertion in the dashboard page.
     */
    @And("^project is displayed in dashboard$")
    public void theNewNameIsDisplayedInDashboard() {
        assertTrue(dashboard.isProjectFound(helper.getProjectVariable()));
    }
}
