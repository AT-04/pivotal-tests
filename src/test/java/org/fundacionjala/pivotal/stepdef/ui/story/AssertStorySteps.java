package org.fundacionjala.pivotal.stepdef.ui.story;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.util.Helper;

import static org.testng.Assert.assertTrue;

/**
 * Created by pivotal-test Team.
 */
public class AssertStorySteps {

    private Project project;
    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param project is the Project class instance.
     * @param helper  is the helper utility class instance.
     */
    public AssertStorySteps(Project project, Helper helper) {
        this.project = project;
        this.helper = helper;

    }

    /**
     * Step definition that perform the assertion.
     */
    @Then("^new story name is displayed in the project page$")
    public void newStoryNameIsDisplayedInTheProjectPage() {
        assertTrue(project.isVisibleStory(helper.getStoryVariable()));
    }
}
