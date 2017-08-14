package org.fundacionjala.pivotal.hook;

import cucumber.api.java.Before;
import org.fundacionjala.pivotal.pages.signin.SignIn;
import org.fundacionjala.pivotal.utilities.Environment;

/**
 * Created by pivotal-test Team.
 */
public class UiHook {

    /**
     * Hook that perform the smart login process.
     */
    @Before("@Login")
    public void login() {
        SignIn.signInAs(Environment.getInstance().getUser(), Environment.getInstance().getPassword());
    }
}
