package org.fundacionjala.pivotal.util;

/**
 * Created by pivotal-test Team.
 */
public class Helper {

    private String projectVariable;
    private int requestStatus;
    private String storyVariable;
    private String workspaceVariable;

    /**
     * This method sets the Project Variable helper attribute.
     *
     * @param projectVariable the value to be set.
     */
    public void setProjectVariable(String projectVariable) {
        this.projectVariable = projectVariable;
    }

    /**
     * This method return the Project Variable helper attribute.
     *
     * @return the variable value.
     */
    public String getProjectVariable() {
        return projectVariable;
    }

    /**
     * This method sets the Request Status helper attribute.
     *
     * @param requestStatus the value to be set
     */
    public void setRequestStatus(int requestStatus) {
        this.requestStatus = requestStatus;
    }

    /**
     * This method return the Request Status helper attribute.
     *
     * @return the variable value.
     */
    public int getRequestStatus() {
        return requestStatus;
    }

    /**
     * This method get the Story Variable helper attribute.
     *
     * @return the variable value.
     */
    public String getStoryVariable() {
        return storyVariable;
    }

    /**
     * This method sets the Story Variable helper attribute.
     *
     * @param storyVariable the variable value.
     */
    public void setStoryVariable(String storyVariable) {
        this.storyVariable = storyVariable;
    }

    /**
     * This method sets the workspace Variable helper attribute.
     *
     * @param workspaceVariable the variable value.
     */
    public void setWorkspaceVariable(String workspaceVariable) {
        this.workspaceVariable = workspaceVariable;
    }

    /**
     * This method get the workspace Variable helper attribute.
     *
     * @return the variable value.
     */
    public String getWorkspaceVariable() {
        return workspaceVariable;
    }
}
