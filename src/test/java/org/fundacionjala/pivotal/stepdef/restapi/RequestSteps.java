package org.fundacionjala.pivotal.stepdef.restapi;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import org.fundacionjala.pivotal.restapi.RequestManager;
import org.fundacionjala.pivotal.utilities.SharedVariableList;

import java.util.Map;

/**
 * Created by pivotal-test Team.
 */
public class RequestSteps {

    private Response response;

    /**
     * Step definition to perform a POST  request.
     *
     * @param endPoint is the specified end point.
     * @param map      is the body content.
     */
    @Given("^that POST request to \"([^\"]*)\" with the following data$")
    public void thatPOSTRequestToWithTheFollowingData(String endPoint, Map<String, String> map) {
        response = RequestManager.post(endPoint, map);
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
