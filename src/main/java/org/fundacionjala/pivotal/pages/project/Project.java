package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.pages.story.StoryBoard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pivotal-test Team.
 */
public class Project extends BasePage {

    @FindBy(className = "raw_context_name")
    private WebElement projectName;

    @FindBy(css = "a[class='button add_story'] > span[class='icon']")
    private WebElement addStoryButton;

    /**
     * This method return the Project name label value of the Project page.
     *
     * @return the text value of the Project name label.
     */
    public String projectName() {
        return projectName.getText();
    }

    /**
     * This method performs click on the Story button.
     *
     * @return new instance of Story Board.
     */
    public StoryBoard enterAddStory() {
        CommonActions.clickButton(addStoryButton);
        return new StoryBoard();
    }

    /**
     * This method verifies if story is visible.
     *
     * @param nameStory is the name story.
     * @return true if the name story is visible.
     */
    public boolean isVisibleStory(String nameStory) {
        String xPath = String.format("//span[@class='story_name' and text()='%s']", nameStory);
        WebElement webElement = webDriver.findElement(By.xpath(xPath));
        return CommonActions.isVisible(webElement);
    }

    /**
     * This method enter an existing story.
     *
     * @param nameStory this variable contains the name of story.
     * @return the story Board page.
     */
    public StoryBoard enterExistingStory(String nameStory) {
        String xPath = String.format("//span[contains(text(),'%s')]/ancestor::div[contains(@data-aid,'StoryPreviewItem')]/descendant::a[contains(@class,'expander')]", nameStory);
        WebElement webElement = webDriver.findElement(By.xpath(xPath));
        webElement.click();
        return new StoryBoard();
    }
}
