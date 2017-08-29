package org.fundacionjala.pivotal.stepdef.ui;

import static org.testng.Assert.assertTrue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.core.util.Navigator;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.util.DataInterpreter;

/**
 * Class containing Common Steps.
 */
public class CommonSteps {

    private Dashboard dashboard;
    private Project project;

    /**
     * This constructor using dependence injection.
     *
     * @param dashboard is the dashboard page object.
     */
    public CommonSteps(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    /**
     * Step definition that perform the navigate to dashboard action.
     */
    @And("^goes to dashboard$")
    public void goToDashboard() {
        Navigator.loadDashboardPage();
    }

    /**
     * this Step definition enter to project page.
     *
     * @param name this variable contains the project name.
     */
    @When("^opens the project created as \"([^\"]*)\"$")
    public void openTheProjectCreatedAs(String name) {
        project = dashboard.enterToProject(DataInterpreter.getValue(name).toString());
    }

    /**
     * this Step definition enter to story page.
     *
     * @param name this variable contains the story name.
     */
    @And("^opens the story created as \"([^\"]*)\"$")
    public void opensTheStoryCreatedAs(String name) {
        project.enterExistingStory(DataInterpreter.getValue(name).toString());
    }

    /**
     * Step definition that perform the assertion message error.
     *
     * @param errorMessage that should be displayed.
     */
    @Then("^validation error message \"([^\"]*)\" should be displayed$")
    public void verifyThatValidationErrorMessageIsDiplayed(String errorMessage) {
        assertTrue(CommonActions.getErrorMessage().contains(errorMessage));
    }
}
