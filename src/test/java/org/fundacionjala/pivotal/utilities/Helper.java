package org.fundacionjala.pivotal.utilities;

/**
 * Created by pivotal-test Team.
 */
public class Helper {

    private String projectVariable;

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
}
