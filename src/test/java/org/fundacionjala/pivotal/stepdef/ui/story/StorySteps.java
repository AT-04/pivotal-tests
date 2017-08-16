package org.fundacionjala.pivotal.stepdef.ui.story;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.story.StoryAttributes;
import org.fundacionjala.pivotal.pages.story.StoryBoard;
import org.fundacionjala.pivotal.pages.story.StoryDeleteDialog;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;

import java.util.Map;

/**
 * Created by pivotal-test Team.
 */
public class StorySteps {

    private Dashboard dashboard;
    private Project project;
    private StoryBoard storyBoard;
    private StoryDeleteDialog storyDeleteDialog;
    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param dashboard is the dashboard class instance.
     * @param helper    is the helper utility class instance.
     */
    public StorySteps(Dashboard dashboard, Helper helper) {
        this.dashboard = dashboard;
        this.helper = helper;
    }

    /**
     * this Step definition enter to project page.
     *
     * @param data this variable contains the project name.
     */
    @And("^the user enters to \"([^\"]*)\" project page$")
    public void theUserEntersToProjectPage(String data) {
        helper.setProjectVariable(DataInterpreter.getValue(data).toString());
        project = dashboard.enterToProject(helper.getProjectVariable());
    }

    /**
     * this Step definition create a story.
     *
     * @param storyAttributesMap this map contains the story attributes.
     */
    @When("^the user create a new story with the following parameters$")
    public void theUserCreateANewStoryWithTheFollowingParameters(Map<StoryAttributes, String> storyAttributesMap) {
        StoryBoard storyBoard = project.enterAddStory();
        project = storyBoard.createdStory(storyAttributesMap);
        helper.setStoryVariable(storyAttributesMap.get(StoryAttributes.STORY_NAME));
    }

    /**
     * this Step definition enter to story.
     *
     * @param data this variable contains the story name.
     */
    @And("^the user enters to \"([^\"]*)\" story page$")
    public void theUserEntersToStoryPage(String data) {
        storyBoard = project.enterExistingStory(DataInterpreter.getValue(data).toString());


    }

    /**
     * this Step definition deletes the story.
     */
    @And("^And delete the Story$")
    public void andDeleteTheStory() {
        storyDeleteDialog = storyBoard.deleteStory();
        project = storyDeleteDialog.confirm();
    }
}
