package org.fundacionjala.pivotal.stepdef.restapi;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import org.fundacionjala.pivotal.core.restapi.RequestManager;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;
import org.fundacionjala.pivotal.util.SharedVariableList;

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
     * @param map   is the map body content.
     */
    @Given("^^a POST request to \"([^\"]*)\" with the following data$")
    public void aPOSTRequestToWithTheFollowingData(String param, Map<String, String> map) {
        response = RequestManager.post(DataInterpreter.builtEndPoint(param), map);
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
        response = RequestManager.delete(DataInterpreter.builtEndPoint(param));
        helper.setRequestStatus(response.getStatusCode());
    }

    /**
     * Step definition to perform a PUT request.
     *
     * @param param is the specified end point.
     * @param map   is the map body content.
     */
    @When("^a PUT request to \"([^\"]*)\" with:$")
    public void aPUTRequestToWith(String param, Map<String, String> map) {
        response = RequestManager.put(DataInterpreter.builtEndPoint(param), map);
    }

    /**
     * Step definition to perform a GET request.
     *
     * @param param is the specified end point.
     */
    @When("^a GET request to \"([^\"]*)\"$")
    public void aGETRequestTo(String param) {
        response = RequestManager.get(DataInterpreter.builtEndPoint(param));
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
