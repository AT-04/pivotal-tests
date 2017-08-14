package org.fundacionjala.pivotal.restapi;

import io.restassured.specification.RequestSpecification;
import org.fundacionjala.pivotal.utilities.Environment;

import static io.restassured.RestAssured.given;

/**
 * Created by pivotal-test Team.
 */
public final class Authentication {
    private static final String BASE_URL_API = "https://www.pivotaltracker.com/services/v5";
    private static final String HEADER_NAME = "X-TrackerToken";
    private static Authentication singleton;
    private RequestSpecification requestSpecification;

    /**
     * This is the constructor for que Authentication singleton class.
     */
    private Authentication() {
        String headerValue = Environment.getInstance().getToken();
        requestSpecification = given().baseUri(BASE_URL_API).header(HEADER_NAME, headerValue);
    }

    /**
     * This method instantiate the singleton object of the Authentication class.
     *
     * @return the singleton instance.
     */
    public static Authentication getSingleton() {
        if (singleton == null) {
            singleton = new Authentication();
        }
        return singleton;
    }

    /**
     * This method return the Request Specification instance.
     *
     * @return the Request Specification instance.
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
