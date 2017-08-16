package org.fundacionjala.pivotal.pages.story;

import org.fundacionjala.pivotal.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pivotal-test Team.
 */
public class StoryDeleteDialog extends BasePage {

  @FindBy(css = "button[data-aid='DeleteButton']")
  private WebElement confirmDeleteButton;

  @FindBy(css = "button[data-aid='CancelButton']")
  private WebElement cancelDeleteButton;

}
