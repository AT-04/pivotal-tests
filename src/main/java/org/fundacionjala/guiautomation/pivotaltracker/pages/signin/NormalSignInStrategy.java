package org.fundacionjala.guiautomation.pivotaltracker.pages.signin;

import org.fundacionjala.guiautomation.pivotaltracker.pages.Dashboard;

/**
 * Created by pivotal-test Team.
 */
public class NormalSignInStrategy implements SignInStrategy {

    /**
     * This method performs a normal logging process.
     *
     * @param signInPage is SigIn page object.
     * @return dashboard page object.
     */
    @Override
    public Dashboard signInProcess(SignIn signInPage) {
        // This condition verifies if the SignInAs Button is visible.
        if (signInPage.isSignInAsOtherBtnVisible()) {
            signInPage.clickSignInAsOtherBtn();
        }
        return signInPage.signInActions();
    }
}
