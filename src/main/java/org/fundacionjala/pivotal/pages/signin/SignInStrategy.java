package org.fundacionjala.pivotal.pages.signin;

import org.fundacionjala.pivotal.pages.Dashboard;

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
    Dashboard signIn(SignIn signInPage);
}
