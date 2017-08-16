package org.fundacionjala.pivotal.pages.story;

import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.core.util.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pivotal-test Team.
 */
public class StoryBoard extends BasePage {

    @FindBy(css = "textarea[name='story[name]']")
    private WebElement storyNameTextField;

    @FindBy(css = "button[class='autosaves button std save']")
    private WebElement storyAutoSaveutton;

    @FindBy(css = "button[class='autosaves button std close']")
    private WebElement storyAutoSaveCloseButton;

    @FindBy(css = "button[title='Delete this story']")
    private WebElement storyDelete;

    //STORY TYPE
    @FindBy(css = "div[class='dropdown story_type'] > a[class='arrow target']")
    private WebElement storyDropdownType;

    //ESTIMATE POINTS
    @FindBy(css = "div[class='dropdown story_estimate'] > a[class='arrow target']")
    private WebElement storyDropdowneEstimatePoints;

    //BLOCKERS
    @FindBy(css = "div[data-aid='BlockerAdd']")
    private WebElement storyBlockerShow;

    @FindBy(css = "textarea[id='blocker-edit-new']")
    private WebElement storyBlokerReasonTextField;

    @FindBy(css = "button[data-aid='BlockerEdit__addButton']")
    private WebElement storyBlockerAddButton;

    //DESCRIPTION
    @FindBy(css = "div[data-aid='renderedDescription']")
    private WebElement storyDescriptionShow;

    @FindBy(css = "textarea[aria-label='Description']")
    private WebElement storyDescriptionTextField;

    @FindBy(css = "button[data-aid='save']")
    private WebElement storyDescriptionSaveButton;

    //LABELS
    @FindBy(css = "input[placeholder='Add a label']")
    private WebElement storyLabelInputField;

    /**
     * This method creates a new story.
     *
     * @param attributesMap This variable contains all attributes of story.
     * @return new project page object.
     */
    public Project createdStory(Map<StoryAttributes, String> attributesMap) {
        StoryStrategyLambda.strategy(attributesMap, this);
        CommonActions.clickButton(storyAutoSaveutton);
        return new Project();
    }

    /**
     * This method sets the name story.
     *
     * @param nameStory This variable contains the name of story.
     */
    public void setNameInputField(String nameStory) {
        CommonActions.setInputField(storyNameTextField, nameStory);
    }

    /**
     * This method set story type.
     *
     * @param storyType This variable enum contains the types.
     */
    public void setStoryType(StoryTypes storyType) {
        CommonActions.clickButton(storyDropdownType);
        String cssSelector = String.format("li[data-value='%s']", storyType.toString().toLowerCase());
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        element.click();
    }

    /**
     * This method set story points.
     *
     * @param storyPoints This variable enum contains the points.
     */
    public void setStoryPoints(StoryPoints storyPoints) {
        CommonActions.clickButton(storyDropdowneEstimatePoints);
        Map<StoryPoints, String> mapPoints = new HashMap<StoryPoints, String>();
        mapPoints.put(StoryPoints.UN_ESTIMATE, "-1");
        mapPoints.put(StoryPoints.ZERO, "0");
        mapPoints.put(StoryPoints.ONE, "1");
        mapPoints.put(StoryPoints.TWO, "2");
        mapPoints.put(StoryPoints.THREE, "3");
        String cssSelector = String.format("li[data-value='%s']", mapPoints.get(storyPoints));
        WebElement element = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssSelector)));
        element.click();
    }

    /**
     * This method sets the blockers.
     *
     * @param storyBlockers This variable contains the blockers.
     */
    public void setStoryBlockers(String storyBlockers) {
        CommonActions.clickButton(storyBlockerShow);
        CommonActions.setInputField(storyBlokerReasonTextField, storyBlockers);
        CommonActions.clickButton(storyBlockerAddButton);
    }

    /**
     * This Method sets story description.
     *
     * @param storyDescription This variable contains the description.
     */
    public void setStoryDescription(String storyDescription) {
        CommonActions.clickButton(storyDescriptionShow);
        CommonActions.setInputField(storyDescriptionTextField, storyDescription);
        CommonActions.clickButton(storyDescriptionSaveButton);
    }

    /**
     * This Method sets label story.
     *
     * @param storyLabel This variable contains the label.
     */
    public void setStoryLabel(String storyLabel) {
        CommonActions.setInputField(storyLabelInputField, storyLabel);
        CommonActions.pressEnterKey(storyLabelInputField);
    }
}
