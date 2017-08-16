package org.fundacionjala.pivotal.hook;

import cucumber.api.java.After;

import org.fundacionjala.pivotal.core.util.Navigator;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Created by pivotal-test Team.
 */
public class UiHook {

    private Helper helper;

    /**
     * Api Hook constructor using Dependency Injection.
     *
     * @param helper object utility instance.
     */
    public UiHook(Helper helper) {
        this.helper = helper;
    }

    /**
     * Hook for delete the created account for the UI tests.
     */
    @After("@DeleteAccount")
    public void deleteAccount() {
        Navigator.loadDashboardPage().clickAccountListItem().deleteAccount(helper.getAccountVariable());
    }
}
