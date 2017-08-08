package org.fundacionjala.guiautomation.pivotaltracker.pages.signin;

import org.fundacionjala.guiautomation.pivotaltracker.pages.Dashboard;

/**
 * Created by pivotal-test Team.
 */
public interface SignInStrategy {

    /**
     * This method performs the sign in process.
     *
     * @param signInPage is signIn page object.
     * @return Dashboard page object.
     */
    Dashboard signInProcess(SignIn signInPage);
}
