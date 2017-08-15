package org.fundacionjala.pivotal.stepdef.ui.project;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.ProjectSettingsForm;
import org.fundacionjala.pivotal.utilities.DataBuilder;

/**
 * Created by pivotal-test Team.
 */
public class DeleteProjectSteps {

    private Dashboard dashboard;
    private ProjectSettingsForm projectSettingsForm;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param dashboard is the dashboard instance.
     */
    public DeleteProjectSteps(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    /**
     * Step definition that perform the click on settings project icon.
     *
     * @param data is the data to be entered.
     */
    @When("^the user enters to \"([^\"]*)\" settings page$")
    public void theUserEntersToSettingsPage(String data) {
        projectSettingsForm = dashboard.clickProjectConfig(DataBuilder.getValue(data).toString());
    }

    /**
     * Step definition that perform the project deletion.
     */
    @And("^delete the Project$")
    public void deleteTheProject() {
        dashboard = projectSettingsForm.deleteProject();
    }
}
