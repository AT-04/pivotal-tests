package org.fundacionjala.pivotal.hook;

import cucumber.api.java.After;
import io.restassured.path.json.JsonPath;
import org.fundacionjala.pivotal.restapi.RequestManager;
import org.fundacionjala.pivotal.utilities.Helper;

import java.util.List;
import java.util.Map;

/**
 * Created by pivotal-test Team.
 */
public class ApiHook {
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
     * Hook for delete a certain project specified for the helper content.
     */
    @After("@DeleteProject")
    public void deleteProject() {
        JsonPath jsonPath = new JsonPath(RequestManager.get("/projects").asString());
        List<Map<String, Object>> projects = jsonPath.get();
        for (Map<String, Object> map : projects) {
            if (map.get("name").equals(helper.getProjectVariable())) {
                RequestManager.delete(String.format("/projects/%s", map.get("id").toString()));
            }
        }
    }
}