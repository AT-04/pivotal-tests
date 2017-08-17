package org.fundacionjala.pivotal.stepdef.ui.workspace;

import cucumber.api.java.en.Then;

import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.workspace.WorkSpaces;
import org.fundacionjala.pivotal.pages.workspace.WorkspaceDashboard;
import org.fundacionjala.pivotal.pages.workspace.WorkspacesCreateForm;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Administrator on 8/16/2017.
 */
public class AssertWorkspaceSteps {
    private Dashboard dashboard;
    private WorkSpaces workSpaces;
    private Helper helper;
    private WorkspaceDashboard workspaceDashboard;
    private WorkspacesCreateForm workspacesCreateForm;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param workSpaces           is the workSpace class instance.
     * @param helper               is the helper class instance.
     * @param workspaceDashboard   is the workspaceDashboard class instance.
     * @param workspacesCreateForm is the workspacesCreateForm class instance.
     * @param dashboard            is the dashboard class instance.
     */
    public AssertWorkspaceSteps(WorkSpaces workSpaces, Helper helper, WorkspaceDashboard workspaceDashboard,
                                WorkspacesCreateForm workspacesCreateForm, Dashboard dashboard) {
        this.workSpaces = workSpaces;
        this.helper = helper;
        this.workspaceDashboard = workspaceDashboard;
        this.workspacesCreateForm = workspacesCreateForm;
        this.dashboard = dashboard;
    }

    /**
     * Step definition that perform the assertion in the workspace main page.
     */
    @Then("^New workspace name is displayed in the workspace main page$")
    public void newWorkspaceNameIsDisplayedInTheWorkspaceMainPage() {
        assertTrue(workSpaces.workSpacesName().equals(helper.getWorkspaceVariable()));
    }

    /**
     * Step definition that perform the assertion in the dashboard.
     */
    @Then("^workspace is displayed in the dashboard$")
    public void newWorkspaceNameIsDisplayedInTheDashboardWorkspace() {
        assertTrue(workspaceDashboard.isWorkspaceFound(helper.getWorkspaceVariable()));
    }

    /**
     * Step definition that perform the assertion message error.
     *
     * @param errorMessage text of message.
     */
    @Then("^error message \"([^\"]*)\"$")
    public void verifyThatMessageError(String errorMessage) {
        assertTrue(workspacesCreateForm.messageErrorWhenNameIsEmpty().contains(errorMessage));
    }

    /**
     * Step definition that perform the assertion message error.
     *
     * @param message text of message.
     */
    @Then("^message \"([^\"]*)\" should displayed$")
    public void messageShouldDisplayed(String message) {
        assertTrue(DataInterpreter.rebuiltMessage(message).equals(dashboard.getNoticeText()));
    }

    /**
     * Step definition that perform the assertion in dashboard.
     *
     * @param nameWorkspace is name workspace.
     */
    @Then("^the \"([^\"]*)\" is not displayed in the dashboard$")
    public void verifyThatIsnTDisplayedInTheDashboard(String nameWorkspace) {
        assertFalse(workspaceDashboard.isWorkspaceFound(nameWorkspace));
    }

    /**
     * Step definition that perform the assertion workspace should displayed.
     *
     * @param newName is new name of workspace.
     */
    @Then("^workspace name should be displayed \"([^\"]*)\"$")
    public void workspaceNameShouldBeDisplayed(String newName) {
        assertTrue(workspaceDashboard.workspaceIsDisplayed(newName));
    }

    /**
     * Step definition that perform the assertion message error.
     *
     * @param errorMessage is text message.
     */
    @Then("^error message \"([^\"]*)\" should be displayed$")
    public void verifyThatMessageErrorWorkspace(String errorMessage) {
        assertTrue(workspacesCreateForm.messageErrorWhenAlreadyName().contains(errorMessage));
    }
}
