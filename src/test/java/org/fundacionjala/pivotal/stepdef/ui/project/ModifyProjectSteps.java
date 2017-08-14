package org.fundacionjala.pivotal.stepdef.ui.project;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.ProjectSettingsForm;
import org.fundacionjala.pivotal.utilities.DataBuilder;
import org.fundacionjala.pivotal.utilities.Helper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by pivotal-test Team.
 */
public class ModifyProjectSteps {
    private Dashboard dashboard;
    private ProjectSettingsForm projectSettingsForm;
    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param dashboard           is the dashboard instance.
     * @param projectSettingsForm is the project settings form instance.
     * @param helper              is the helper utility class instance.
     */
    public ModifyProjectSteps(Dashboard dashboard,
                              ProjectSettingsForm projectSettingsForm, Helper helper) {
        this.dashboard = dashboard;
        this.projectSettingsForm = projectSettingsForm;
        this.helper = helper;
    }

    /**
     * Step definition that perform the the project name modification.
     *
     * @param newName is the new name for the project.
     */
    @And("^modify the name to \"([^\"]*)\"$")
    public void modifyTheNameTo(String newName) {
        helper.setProjectVariable(newName);
        projectSettingsForm.modifyProjectName(newName);
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
    @Then("^the old \"([^\"]*)\" is not displayed in Dashboard$")
    public void theOldIsNotDisplayedInDashboard(String name) {
        assertFalse(dashboard.isProjectFound(DataBuilder.getSingleValue(name).toString()));
    }

    /**
     * Step definition that perform the assertion in the dashboard page.
     */
    @And("^the new name is displayed in Dashboard$")
    public void theNewNameIsDisplayedInDashboard() {
        assertTrue(dashboard.isProjectFound(helper.getProjectVariable()));
    }
}
