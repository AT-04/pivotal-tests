package org.fundacionjala.pivotal.hook;

import java.util.List;
import java.util.Map;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.path.json.JsonPath;

import org.fundacionjala.pivotal.core.restapi.RequestManager;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;
import org.fundacionjala.pivotal.util.SharedVariableList;

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
        SharedVariableList.getList().stream()
                .filter(element -> element.getName().contains("Project"))
                .forEach(project -> {
                    String format = String.format("/projects/[%s.id]", project.getName());
                    RequestManager.delete(DataInterpreter.builtEndPoint(format));
                });
    }

    /**
     * Hook for delete a workspace specified for the helper content.
     */
    @After("@DeleteWorkspace")
    public void deleteWorkspace() {
        SharedVariableList.getList().stream()
                .filter(element -> element.getName().contains("Workspace"))
                .forEach(workspace -> {
                    String format = String.format("/my/workspaces/[%s.id]", workspace.getName());
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
}
