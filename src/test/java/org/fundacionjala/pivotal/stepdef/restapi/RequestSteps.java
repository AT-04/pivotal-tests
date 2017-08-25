package org.fundacionjala.pivotal.stepdef.restapi;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.restassured.response.Response;

import org.fundacionjala.pivotal.core.restapi.RequestManager;
import org.fundacionjala.pivotal.core.restapi.RequestType;
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
     * Step definition to store the response data to a shared variable.
     *
     * @param name the name of the shared variable.
     */
    @And("^stored as \\[([^\"]*)]$")
    public void storedAsProject(String name) {
        SharedVariableList.addVariable(name, response);
    }

    /**
     * Step definition to perform a POST or PUT request.
     *
     * @param method is the request type.
     * @param param  is the specified end point.
     * @param map    is the map body content.
     */
    @When("^a \"(POST|PUT)\" request to \"([^\"]*)\" with$")
    public void aRequestToWith(RequestType method, String param, Map<String, String> map) {
        response = RequestManager.requestPostOrPut(method, DataInterpreter.builtEndPoint(param), map);
        helper.setRequestStatus(response.getStatusCode());
    }

    /**
     * Step definition to perform a GET or DELETE request.
     *
     * @param method is the request type.
     * @param param  is the specified end point.
     */
    @When("^a \"(GET|DELETE)\" request to \"([^\"]*)\"$")
    public void aRequestTo(RequestType method, String param) {
        response = RequestManager.requestGetOrDelete(method, DataInterpreter.builtEndPoint(param));
        helper.setRequestStatus(response.getStatusCode());
    }
}
