package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.pages.BasePage;
import org.fundacionjala.pivotal.core.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pivotal-test Team.
 */
public class WorkspaceSettings extends BasePage {
  @FindBy(id = "workspace_name")
  private WebElement workspaceNameTextField;

  @FindBy(css = "input.save_bar__submit")
  private WebElement saveBtn;

  @FindBy(id = "delete_link")
  private WebElement deleteLink;

  @FindBy(id = "confirm_delete")
  private WebElement confirmDeleteBtn;

  /**
   * This method input change workspace.
   *
   * @param newName is new name for workspace.
   */
  public void updateName(String newName) {
    CommonActions.setInputField(workspaceNameTextField, newName);
  }

  /**
   * This method save the change.
   */
  public void clickSaveBtn() {
    CommonActions.clickButton(saveBtn);
  }

  /**
   * This method delete a workspace.
   */
  public void deleteWorkspace() {
    CommonActions.clickButton(deleteLink);
  }

  /**
   * This method confirm to delete a workspace.
   */
  public void confirmDelete() {
    CommonActions.clickButton(confirmDeleteBtn);
  }
}
