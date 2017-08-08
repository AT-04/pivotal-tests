package org.fundacionjala.guiautomation.pivotaltracker.pages.signin;

import org.fundacionjala.guiautomation.pivotaltracker.pages.Dashboard;

/**
 * Created by pivotal-test Team.
 */
public interface SignInStrategy {

    /**
     * This method makes the process of sign in.
     *
     * @param signInPage is signIn page object.
     * @return Dashboard page object.
     */
    Dashboard signInProcess(SignIn signInPage);
}
