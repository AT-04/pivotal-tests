package org.fundacionjala.pivotal.stepdef.ui.project;

import cucumber.api.java.en.And;
import org.fundacionjala.pivotal.pages.project.ProjectSettingsForm;
import org.fundacionjala.pivotal.utilities.Helper;

/**
 * Created by pivotal-test Team.
 */
public class ModifyProjectSteps {
    private ProjectSettingsForm projectSettingsForm;
    private Helper helper;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param projectSettingsForm is the project settings form instance.
     * @param helper              is the helper utility class instance.
     */
    public ModifyProjectSteps(ProjectSettingsForm projectSettingsForm, Helper helper) {
        this.projectSettingsForm = projectSettingsForm;
        this.helper = helper;
    }

    /**
     * Step definition that perform the the project name modification.
     *
     * @param newName is the new name for the project.
     */
    @And("^modify the name to \"([^\"]*)\"$")
    public void modifyTheNameTo(String newName) {
        helper.setProjectVariable(newName);
        projectSettingsForm.modifyProjectName(newName);
    }
}
