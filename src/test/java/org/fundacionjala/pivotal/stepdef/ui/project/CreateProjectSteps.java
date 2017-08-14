package org.fundacionjala.pivotal.stepdef.ui.project;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.CreateProjectForm;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.project.ProjectAttributes;
import org.fundacionjala.pivotal.utilities.Helper;
import org.fundacionjala.pivotal.utilities.Navigator;

import java.util.Map;

import static org.testng.Assert.assertTrue;


/**
 * Created by pivotal-test Team.
 */
public class CreateProjectSteps {

    private Dashboard dashboard;
    private Project project;
    private CreateProjectForm createProjectForm;
    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param dashboard is the dashboard instance.
     * @param helper    is the helper utility class instance.
     */
    public CreateProjectSteps(Dashboard dashboard, Helper helper) {
        this.dashboard = dashboard;
        this.helper = helper;
    }

    /**
     * Step definition that perform the click on the new project button.
     */
    @And("^click on the new project button$")
    public void clickOnTheNewProjectButton() {
        createProjectForm = dashboard.clickProjectBtn();
    }

    /**
     * Step definition that perform the create new Project actions.
     *
     * @param attributesMap is the attributes map to use.
     */
    @When("^the user create a new project with the following parameters$")
    public void theUserCreateANewProjectWithTheFollowingParameters(Map<ProjectAttributes, String> attributesMap) {
        project = createProjectForm.createProject(attributesMap);
        helper.setProjectVariable(attributesMap.get(ProjectAttributes.NAME));
    }

    /**
     * Step definition that perform the assertion in the project main page.
     */
    @Then("^new project name is displayed in the project main page$")
    public void newProjectNameIsDisplayedInTheProjectMainPage() {
        assertTrue(project.projectName().contains(helper.getProjectVariable()));
    }

    /**
     * Step definition that perform the navigate to dashboard action.
     */
    @And("^the user go to Dashboard$")
    public void goToDashboard() {
        Navigator.loadDashboardPage();
    }

    /**
     * * Step definition that perform the assertion in the dashboard page.
     */
    @Then("^new project name is displayed in the dashboard$")
    public void newProjectNameIsDisplayedInTheDashboard() {
        assertTrue(dashboard.isProjectFound(helper.getProjectVariable()));
    }
}
