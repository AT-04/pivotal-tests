package org.fundacionjala.guiautomation.pivotaltracker.pages;

import org.fundacionjala.guiautomation.pivotaltracker.CommonActions;
import org.fundacionjala.guiautomation.pivotaltracker.pages.signin.SignIn;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by pivotal-test Team.
 */
public class Dashboard extends BasePage {

    @FindBy(css = "div[data-aid='ProfileDropdown'] > button")
    private WebElement usernameButton;

    @FindBy(css = "button[data-aid='ProfileDropdown__signout']")
    private WebElement signOutButton;

    @FindBy(css = "a[data-aid='ProfileDropdown__profile']")
    private WebElement profileButton;

    /**
     * This method presses the user name Button.
     */
    private void clickUsernameBtn() {
        CommonActions.clickButton(usernameButton);
    }

    /**
     * This method presses the sign out Button.
     */
    private void clickSignOutBtn() {
        CommonActions.clickButton(signOutButton);
    }

    /**
     * This method presses profile button.
     *
     * @return profile object page.
     */
    private Profile clickProfileButton() {
        clickUsernameBtn();
        CommonActions.clickButton(profileButton);
        return new Profile();
    }

    /**
     * This verifies if is correct user logged.
     *
     * @param username user name.
     * @return true if is correct user or false if it is not.
     */
    public boolean isCorrectUserLogged(String username) {
        Dashboard dashboard = new Dashboard();
        return dashboard.clickProfileButton().isCorrectUserLogged(username);
    }

    /**
     * This method closes the existing session.
     *
     * @param signIn is signIn page object.
     * @return singIn page Object.
     */
    public SignIn signOut(SignIn signIn) {
        clickUsernameBtn();
        clickSignOutBtn();
        return signIn;
    }
}
