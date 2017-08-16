package org.fundacionjala.pivotal.stepdef.ui;

import cucumber.api.java.en.And;
import org.fundacionjala.pivotal.core.util.Navigator;

/**
 * Created by pivotal-test Team.
 */
public class CommonSteps {

    /**
     * Step definition that perform the navigate to dashboard action.
     */
    @And("^the user go to Dashboard$")
    public void goToDashboard() {
        Navigator.loadDashboardPage();
    }
}
