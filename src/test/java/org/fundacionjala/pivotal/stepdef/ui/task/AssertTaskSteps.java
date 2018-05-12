package org.fundacionjala.pivotal.stepdef.ui.task;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.task.Task;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;
import org.testng.asserts.Assertion;

/**
 * Created by Pivotal Team.
 */
public class AssertTaskSteps {

    private final Helper helper;
    private final Assertion assertion;
    private final Task task;

    /**
     * Constructor with dependency injection.
     *
     * @param task   Task.
     * @param helper Helper.
     */
    public AssertTaskSteps(final Task task, final Helper helper) {
        this.task = task;
        this.helper = helper;
        this.assertion = helper.getAssertion();
    }

    /**
     * This step definition verify if a task description is shown.
     */
    @Then("^task is displayed in the story page$")
    public void taskIsDisplayedInTheStoryPage() {
        assertion.assertTrue(task.isDisplayed(helper.getTaskVariable()));
    }

    /**
     * This definition step verify that a task description is not shown.
     *
     * @param data task description.
     */
    @Then("^the \"([^\"]*)\" should not be displayed$")
    public void theShouldNotBeDisplayed(final String data) {
        assertion.assertFalse(task.isDisplayed(DataInterpreter.getValue(data).toString()));
    }

    /**
     * This Definition step verify that a task is done.
     *
     * @param number task name.
     */
    @And("^the task is displayed has checked \"([^\"]*)\"$")
    public void theTaskIsDisplayedHasChecked(final String number) {
        assertion.assertTrue(task.getTaskCounts().contains(String.format("TASKS (%s/", number)));
    }
}
