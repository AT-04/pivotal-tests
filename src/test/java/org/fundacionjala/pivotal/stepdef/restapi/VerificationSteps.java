package org.fundacionjala.pivotal.stepdef.restapi;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.utilities.Helper;

import static org.testng.Assert.assertEquals;

/**
 * Created by pivotal-test Team.
 */
public class VerificationSteps {

    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param helper is the helper utility class instance.
     */
    public VerificationSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Step definition that perform the assert of the status code.
     *
     * @param status the received status code.
     */
    @Then("^the status code should be (\\d+)$")
    public void theStatusCodeShouldBe(int status) {
        assertEquals(status, helper.getRequestStatus());
    }
}
