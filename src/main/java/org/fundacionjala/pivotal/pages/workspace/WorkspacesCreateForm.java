package org.fundacionjala.pivotal.pages.workspace;


import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.core.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pivotal-test Team.
 */
public class WorkspacesCreateForm extends BasePage {

  @FindBy(className = "tc-form__input")
  private WebElement workSpaceNameInputField;

  @FindBy(xpath = "//button[@data-aid='FormModal__submit']")
  private WebElement createWorkSpaceBtn;

  @FindBy(css = "div.tc-form-modal__section > div.tc-form__input--error-message")
  private WebElement messageError;

  @FindBy(css = "div.tc-form__input--error-message span")
  private WebElement messageErrorEmpty;


  /**
   * This method sets the workspace name parameter in the workspace name input field.
   *
   * @param workSpaceName is the new Project name.
   */
  public void setNameInputField(String workSpaceName) {
    CommonActions.setInputField(workSpaceNameInputField, workSpaceName);
  }

  /**
   * This method return the text of message de error when a name workspace already exist.
   *
   * @return the text of message error.
   */
  public String messageErrorWhenAlreadyName() {
    return messageError.getText();
  }

  /**
   * This method return the text of message de error when a name workspace is empty.
   *
   * @return the text of message error.
   */
  public String messageErrorWhenNameIsEmpty() {
    return messageErrorEmpty.getText();
  }

  /**
   * This method save change.
   *
   * @return a new instance of Workspace.
   */
  public WorkSpaces clickSaveBtn() {
    CommonActions.clickButton(createWorkSpaceBtn);
    return new WorkSpaces();
  }
}
