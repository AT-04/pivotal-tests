package org.fundacionjala.pivotal.stepdef.restapi;

import static org.testng.Assert.assertEquals;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Class containing Verification Steps.
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
        assertEquals(helper.getRequestStatus(), status);
    }
}
