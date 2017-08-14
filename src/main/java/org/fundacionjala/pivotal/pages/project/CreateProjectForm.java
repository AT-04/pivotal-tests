package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.utilities.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

/**
 * Created by pivotal-test Team.
 */
public class CreateProjectForm extends BasePage {

    private static final int TIME_WAIT_DURATION = 3;

    @FindBy(className = "tc-form__input")
    private WebElement projectNameInputField;

    @FindBy(className = "tc-account-selector__header")
    private WebElement accountSelect;

    @FindBy(className = "tc-account-selector__create-account-text")
    private WebElement createNewAccountSelectOption;

    @FindBy(className = "tc-account-creator__name")
    private WebElement newAccountNameInputField;

    @FindBy(css = "input[data-aid='public']")
    private WebElement publicRadioButton;

    @FindBy(css = "input[data-aid='private']")
    private WebElement privateRadioButton;

    @FindBy(xpath = "//button[@data-aid='FormModal__submit']")
    private WebElement createProjectButton;

    @FindBy(className = "tc-account-selector__option-account-name")
    private List<WebElement> accountsList;

    /**
     * This method sets the Project name parameter in the Project name input field.
     *
     * @param projectName is the new Project name.
     */
    public void setNameInputField(String projectName) {
        CommonActions.setInputField(projectNameInputField, projectName);
    }

    /**
     * This method perform a click on the account selector WebElement.
     */
    private void clickAccountSelector() {
        CommonActions.clickButton(accountSelect);
    }

    /**
     * This method sets the Account name parameter in the Account name input field.
     *
     * @param accountName is the new Account name.
     */
    public void setNewAccountNameInputField(String accountName) {
        CommonActions.setInputField(newAccountNameInputField, accountName);
    }

    /**
     * This method perform a click on the Create Project button.
     */
    private void clickCreateProjectButton() {
        CommonActions.clickButton(createProjectButton);
    }

    /**
     * This method perform a click on the Public Privacy radio button.
     */
    private void clickPublicRadioButton() {
        CommonActions.clickButton(publicRadioButton);
    }

    /**
     * This method perform a click on the Public Privacy radio button.
     */
    private void clickPrivateRadioButton() {
        CommonActions.clickButton(privateRadioButton);
    }

    /**
     * This method perform a click on the Create New Account option.
     */
    private void clickCreateNewAccountSelectOption() {
        CommonActions.clickButton(createNewAccountSelectOption);
    }

    /**
     * This method perform the actions to create a new project based in a specified strategy.
     *
     * @param attributes the attributes map.
     * @return a Project class instance.
     */
    public Project createProject(Map<ProjectAttributes, String> attributes) {
        ProjectStrategyLambda.strategy(attributes, this);
        clickCreateProjectButton();
        return new Project();
    }

    /**
     * This method set the Account name, create a new Account if the name parameter is not registered
     * and selects the account if exist.
     *
     * @param name is the Account name.
     */
    public void setAccount(String name) {
        clickAccountSelector();
        WebElement webElement = CommonActions.findWebElement(accountsList, name);
        if (webElement != null) {
            CommonActions.clickButton(webElement);
            return;
        }
        createNewAccount(name);
    }

    /**
     * This method perform the actions for create a new Account.
     *
     * @param name is the new Account name.
     */
    private void createNewAccount(String name) {
        clickCreateNewAccountSelectOption();
        setNewAccountNameInputField(name);
    }

    /**
     * This method sets the Project privacy according to the received parameter value.
     *
     * @param privacy is the privacy type value.
     */
    public void setPrivacy(String privacy) {
        if (privacy.equalsIgnoreCase("public")) {
            clickPublicRadioButton();
            return;
        }
        clickPrivateRadioButton();
    }
}