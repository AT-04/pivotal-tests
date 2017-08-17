package org.fundacionjala.pivotal.stepdef.ui.workspace;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.workspace.WorkspaceDashboard;
import org.fundacionjala.pivotal.pages.workspace.WorkspaceSettings;
import org.fundacionjala.pivotal.pages.workspace.WorkspacesCreateForm;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Created by Administrator on 8/16/2017.
 */
public class WorkspaceSteps {
    private Dashboard dashboard;
    private Helper helper;
    private WorkspaceDashboard workspaceDashboard;
    private WorkspacesCreateForm workspacesCreateForm;
    private WorkspaceSettings workspaceSettings;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param dashboard is the dashboard instance.
     * @param helper    is the helperis instance.
     */
    public WorkspaceSteps(Dashboard dashboard, Helper helper) {
        this.dashboard = dashboard;
        this.helper = helper;
    }

    /**
     * Step definition that perform the navigation to workspace tab.
     */
    @And("^The user click on the workspace$")
    public void theUserClickOnTheWorkspace() {
        workspaceDashboard = dashboard.clickWorkspaceBtn();
    }

    /**
     * Step definition that perform the navigation to create workspace button.
     */
    @And("^clicks on the new workspace button$")
    public void theUserClickOnTheNewWorkspaceButton() {
        workspacesCreateForm = workspaceDashboard.clickCreateWorkspaceBtn();
    }

    /**
     * Step definition that perform the create new Workspace.
     *
     * @param body is the attributes map to use.
     */
    @When("^sets workspace with$")
    public void theUserCreateANewWorkspaceWithTheFollowingParameters(Map<String, String> body) {
        workspacesCreateForm.setNameInputField(body.get("Name"));
        workspacesCreateForm.clickSaveBtn();
        helper.setWorkspaceVariable(body.get("Name"));
    }

    /**
     * Step definition that perform navigate to workspace tab.
     */
    @And("^goes to workspace tab$")
    public void goToDashboardWorkspace() {
        workspaceDashboard = dashboard.clickWorkspaceBtn();
    }

    /**
     * Step definition that perform setting workspace.
     *
     * @param nameWorkspace is the name workspace.
     */
    @When("^opens the workspace settings created as \"([^\"]*)\"$")
    public void theUserEnterToWorkspaceSettingPage(String nameWorkspace) {
        workspaceDashboard = dashboard.clickWorkspaceBtn();
        workspaceSettings = workspaceDashboard.selectWorkspace(DataInterpreter.getValue(nameWorkspace).toString());
    }

    /**
     * Step definition modify name workspace.
     *
     * @param newName is the new name workspace.
     */
    @And("^modify the name workspace to \"([^\"]*)\"$")
    public void modifyTheNameWorkspaceTo(String newName) {
        helper.setWorkspaceVariable(newName);
        workspaceSettings.updateName(newName);
        workspaceSettings.clickSaveBtn();
    }

    /**
     * Step definition perform delete link.
     */
    @And("^delete the workspace$")
    public void delete() {
        workspaceSettings.deleteWorkspace();
        workspaceSettings.confirmDelete();
    }
}
