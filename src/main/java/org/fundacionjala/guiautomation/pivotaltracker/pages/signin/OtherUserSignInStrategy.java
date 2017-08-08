package org.fundacionjala.guiautomation.pivotaltracker.pages.signin;

import org.fundacionjala.guiautomation.pivotaltracker.pages.Dashboard;

/**
 * Created by pivotal-test Team.
 */
public class OtherUserSignInStrategy implements SignInStrategy {

    /**
     * This method perform the login with another user account.
     * If the user is the correct return dashboard page,
     * if the user isn't correct return dashboard but
     * before leave the session and log in with the correct
     * user.
     *
     * @param signIn is the SignIn page object.
     * @return dashboard page object.
     */
    @Override
    public Dashboard signInProcess(SignIn signIn) {
        Dashboard dashboard = new Dashboard();
        dashboard = dashboard.isCorrectUserLogged(signIn.getUsername())
                ? dashboard
                : dashboard.signOut(signIn).strategyProcess(new NormalSignInStrategy());
        return dashboard;
    }
}
