package org.fundacionjala.pivotal.pages.task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BasePage;


/**
 * Created by pivotal-test Team.
 */
public class Task extends BasePage {

    @FindBy(css = "div[data-aid='TaskAdd']")
    private WebElement addNewTaskIcon;

    @FindBy(css = "textarea[data-aid='new']")
    private WebElement descriptionTaskInputField;

    @FindBy(css = "button[data-aid='addTaskButton']")
    private WebElement addTaskButton;

    @FindBy(css = "div[data-aid='TaskDescription']")
    private List<WebElement> descriptionList;

    @FindBy(xpath = "//div[@data-aid='TaskDescription']/p[text()='Visit the Members section of the project and ']"
            + "/parent::div/preceding-sibling::label/descendant::input[@type='checkbox']")
    private WebElement taskDoneCheckBox;

    /**
     * This method perform a click on the add new task icon WebElement.
     */
    private void clickAddNewTask() {
        CommonActions.clickButton(addNewTaskIcon);
    }

    /**
     * This method sets the task description parameter in the Task description input field.
     *
     * @param taskDescription String.
     */
    public void setTaskDescription(String taskDescription) {
        clickAddNewTask();
        CommonActions.setInputField(descriptionTaskInputField, taskDescription);
        CommonActions.pressEnterKey(descriptionTaskInputField);
    }

    /**
     * This method peroform a click on the add task button WebElement.
     */
    private void clickSaveTask() {
        CommonActions.clickButton(addTaskButton);
    }

    /**
     * This method perform a click on the task done check box WebElement.
     */
    private void clickTaskDoneCheckBox() {
        CommonActions.clickButton(taskDoneCheckBox);
    }

    /**
     * This method perform a click on the delete task button WebElement.
     *
     * @param taskDescription is name field for task.
     */
    public void clickDeleteTask(String taskDescription) {
        //WebElement webElement = CommonActions.findWebElement(descriptionList, taskDescription);
        String xPathSelector = String.format(
                "//div[@data-aid='TaskDescription']/p[text()='%s'] "
                        + "/parent::div/preceding-sibling::nav/descendant::span[@data-aid='delete'] ",
                taskDescription);
        WebElement element = webDriver.findElement(By.xpath(xPathSelector));
        //new Actions(webDriver).moveToElement(webElement).click(element).build().perform();
        CommonActions.jsClickElement(element);
    }

    /**
     * This method is used for know if a task is shown in the story board.
     * @param taskVariable is the task description.
     * @return webElement.
     */
    public boolean isDisplayed(String taskVariable) {
        WebElement webElement = CommonActions.findWebElement(descriptionList, taskVariable);
        return webElement != null;
    }

}
