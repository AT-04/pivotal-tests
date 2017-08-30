package org.fundacionjala.pivotal.hook;

import java.util.List;
import java.util.Map;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.fundacionjala.pivotal.core.browser.DriverManager;
import org.fundacionjala.pivotal.core.restapi.RequestManager;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;
import org.fundacionjala.pivotal.util.SharedVariableList;

/**
 * Created by pivotal-test Team.
 */
public class ApiHook {

    private static final String PROJECT_ENDPOINT = "/projects/[%s.id]";
    private static final String WORKSPACE_ENDPOINT = "/my/workspaces/[%s.id]";
    private static final String WORKSPACE_TYPE = "workspace";
    private static final String PROJECT_TYPE = "project";
    private Helper helper;

    /**
     * Api Hook constructor using Dependency Injection.
     *
     * @param helper object utility instance.
     */
    public ApiHook(Helper helper) {
        this.helper = helper;
    }

    /**
     * This method clean all the values of the Shared Variables List.
     */
    @Before
    public void cleanSharedVariables() {
        SharedVariableList.cleanList();
    }

    /**
     * Hook for delete a certain project specified for the helper content.
     */
    @After("@DeleteProject")
    public void deleteProject() {
        deleteRequests(PROJECT_TYPE, PROJECT_ENDPOINT);
    }

    /**
     * Hook for delete a workspace specified for the helper content.
     */
    @After("@DeleteWorkspace")
    public void deleteWorkspace() {
        deleteRequests(WORKSPACE_TYPE, WORKSPACE_ENDPOINT);
    }

    /**
     * This method perform the delete request of all elements of certain type stored in the
     * Shared variable list.
     *
     * @param type     is the type of element.
     * @param endpoint is the endpoint format.
     */
    private void deleteRequests(String type, String endpoint) {
        SharedVariableList.getList().stream()
                .filter(variable -> variable.getType().equals(type))
                .forEach(element -> {
                    String format = String.format(endpoint, element.getName());
                    RequestManager.delete(DataInterpreter.builtEndPoint(format));
                });
    }

    /**
     * Hook for delete a certain project specified for the helper content.
     */
    @After("@DeleteSingleProject")
    public void deleteSingleProject() {
        JsonPath jsonPath = new JsonPath(RequestManager.get("/projects").asString());
        List<Map<String, Object>> projects = jsonPath.get();
        for (Map<String, Object> map : projects) {
            if (map.get("name").equals(helper.getProjectVariable())) {
                RequestManager.delete(String.format("/projects/%s", map.get("id").toString()));
            }
        }
    }

    /**
     * Hook for delete a certain workspace specified for the helper content.
     */
    @After("@DeleteSingleWorkspace")
    public void deleteSingleWorkSpace() {
        JsonPath jsonPath = new JsonPath(RequestManager.get("/my/workspaces").asString());
        List<Map<String, Object>> workspace = jsonPath.get();
        for (Map<String, Object> map : workspace) {
            if (map.get("name").equals(helper.getWorkspaceVariable())) {
                RequestManager.delete(String.format("/my/workspaces/%s", map.get("id").toString()));
            }
        }
    }

    /**
     * Takes a snapshot when a scenario fails.
     *
     * @param scenario variable for Cucumber features.
     */
    @After
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
    }
}
