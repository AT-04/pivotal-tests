package org.fundacionjala.pivotal.hook;

import cucumber.api.java.After;

import org.fundacionjala.pivotal.core.restapi.RequestManager;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.SharedVariableList;

/**
 * Created by pivotal-test Team.
 */
public class ApiHook {

    /**
     * Api Hook constructor using Dependency Injection.
     * .
     */
    public ApiHook() {
    }

    /**
     * Hook for delete a certain project specified for the helper content.
     */
    @After("@DeleteProject")
    public void deleteProject() {
        SharedVariableList.getList().stream()
                .filter(element -> element.getName().contains("Project"))
                .forEach(project -> {
                    final String format = String.format("/projects/[%s.id]", project.getName());
                    RequestManager.delete(DataInterpreter.builtEndPoint(format));
                });
        SharedVariableList.cleanList();
    }

    /**
     * Hook for delete a workspace specified for the helper content.
     */
    @After("@DeleteWorkspace")
    public void deleteWorkspace() {
        SharedVariableList.getList().stream()
                .filter(element -> element.getName().contains("Workspace"))
                .forEach(workspace -> {
                    final String format = String.format("/my/workspaces/[%s.id]", workspace.getName());
                    RequestManager.delete(DataInterpreter.builtEndPoint(format));
                });
        SharedVariableList.cleanList();
    }
}
