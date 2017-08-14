package org.fundacionjala.pivotal.pages.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by pivotal-test Team.
 */
public final class ProjectStrategyLambda {

    /**
     * Private constructor for the Project Strategy Lambda utility class.
     */
    private ProjectStrategyLambda() {

    }

    /**
     * This method execute the steps to perform the fill of the fields in the Create Project Form.
     *
     * @param attributesMap     is the Map that contains the attributes.
     * @param createProjectForm is the Create Project Form instance.
     */
    public static void strategy(Map<ProjectAttributes, String> attributesMap, CreateProjectForm createProjectForm) {
        Map<ProjectAttributes, ProjectStep> strategyOption = strategySetAttributes(attributesMap, createProjectForm);
        Set<ProjectAttributes> attributes = attributesMap.keySet();
        attributes.forEach((attributeItem) -> strategyOption.get(attributeItem).executeStep());
    }

    /**
     * This method completes the fields in the Create Project Form with a specific strategy.
     *
     * @param attributesMap     is the Map that contains the attributes.
     * @param createProjectForm is the Create Project Form instance.
     * @return the Map that contains Project Attributes with a specific Project Step.
     */
    private static Map<ProjectAttributes, ProjectStep> strategySetAttributes(
            Map<ProjectAttributes, String> attributesMap, CreateProjectForm createProjectForm) {
        Map<ProjectAttributes, ProjectStep> strategyMap = new HashMap<>();
        strategyMap.put(ProjectAttributes.NAME,
                () -> createProjectForm.setNameInputField(attributesMap.get(ProjectAttributes.NAME)));
        strategyMap.put(ProjectAttributes.ACCOUNT,
                () -> createProjectForm.setAccount(attributesMap.get(ProjectAttributes.ACCOUNT)));
        strategyMap.put(ProjectAttributes.PRIVACY,
                () -> createProjectForm.setPrivacy(attributesMap.get(ProjectAttributes.PRIVACY)));
        return strategyMap;
    }
}
