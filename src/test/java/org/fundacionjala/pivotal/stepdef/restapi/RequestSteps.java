package org.fundacionjala.pivotal.stepdef.restapi;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.fundacionjala.pivotal.restapi.RequestManager;
import org.fundacionjala.pivotal.utilities.DataBuilder;
import org.fundacionjala.pivotal.utilities.Helper;
import org.fundacionjala.pivotal.utilities.SharedVariableList;

import java.util.Map;

/**
 * Created by pivotal-test Team.
 */
public class RequestSteps {

    private Response response;
    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param helper is the helper utility class instance.
     */
    public RequestSteps(Helper helper) {
        this.helper = helper;
    }

    /**
     * Step definition to perform a POST  request.
     *
     * @param param is the specified end point.
     * @param map   is the body content.
     */
    @Given("^^a POST request to \"([^\"]*)\" with the following data$")
    public void aPOSTRequestToWithTheFollowingData(String param, Map<String, String> map) {
        response = RequestManager.post(DataBuilder.builtEndPoint(param), map);
        helper.setRequestStatus(response.getStatusCode());
        helper.setProjectVariable(map.get("name"));
    }

    /**
     * Step definition to perform a DELETE request.
     *
     * @param param is the specified end point.
     */
    @When("^a DELETE request to \"([^\"]*)\"$")
    public void aDELETERequestTo(String param) {
        response = RequestManager.delete(DataBuilder.builtEndPoint(param));
        helper.setRequestStatus(response.getStatusCode());
        System.out.println(helper.getRequestStatus());
    }

    /**
     * Step definition to store the response data to a shared variable.
     *
     * @param name the name of the shared variable.
     */
    @And("^stored as \\[([^\"]*)]$")
    public void storedAsProject(String name) {
        SharedVariableList.addVariable(name, response);
    }
}
