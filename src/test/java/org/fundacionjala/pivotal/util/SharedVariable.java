package org.fundacionjala.pivotal.util;

import java.util.Map;

/**
 * Created by pivotal-test Team.
 */
public class SharedVariable {
    private String variableName;
    private Map<String, Object> attributesMap;

    /**
     * Constructor for the Shared Variable class.
     *
     * @param variableName  is the name of the variable.
     * @param attributesMap is the attributes map that contains keys and values.
     */
    public SharedVariable(String variableName, Map<String, Object> attributesMap) {
        this.variableName = variableName;
        this.attributesMap = attributesMap;
    }

    /**
     * This method return the name of the Shared Value.
     *
     * @return the name of the variable.
     */
    public String getName() {
        return variableName;
    }

    /**
     * This method return a attribute value of a specified key.
     *
     * @param attribute is the key identifier.
     * @return the string value representation.
     */
    public String getAttributeValue(String attribute) {
        return attributesMap.get(attribute).toString();
    }
}
