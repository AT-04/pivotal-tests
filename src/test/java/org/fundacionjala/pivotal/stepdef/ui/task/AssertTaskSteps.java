package org.fundacionjala.pivotal.stepdef.ui.task;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.fundacionjala.pivotal.pages.task.Task;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Pivotal Team.
 */
public class AssertTaskSteps {

    private Task task;
    private Helper helper;

    /**
     * Constructor with dependency injection.
     *
     * @param task   Task.
     * @param helper Helper.
     */
    public AssertTaskSteps(Task task, Helper helper) {
        this.task = task;
        this.helper = helper;
    }

    /**
     * This step definition verify if a task description is shown.
     */
    @Then("^task is displayed in the story page$")
    public void taskIsDisplayedInTheStoryPage() {
        assertTrue(task.isDisplayed(helper.getTaskVariable()));
    }

    /**
     * This definition step verify that a task description is not shown.
     *
     * @param data task description.
     */
    @Then("^the \"([^\"]*)\" should not be displayed$")
    public void theShouldNotBeDisplayed(String data) {
        assertFalse(task.isDisplayed(DataInterpreter.getValue(data).toString()));
    }

    /**
     * This Definition step verify that a task is done.
     * @param number task name.
     */
    @And("^the task is displayed has checked \"([^\"]*)\"$")
    public void theTaskIsDisplayedHasChecked(String number)   {
        assertTrue(task.getTaskCounts().contains(String.format("TASKS (%s/", number)));
    }
}
