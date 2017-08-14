package org.fundacionjala.pivotal.utilities;

/**
 * Created by pivotal-test Team.
 */
public final class DataBuilder {

    /**
     * Private constructor for the Data Builder utility class.
     */
    private DataBuilder() {

    }

    /**
     * This method return the value of a key stored in the Shared Variables List.
     * Receives a String where the key and value are enclosed in brackets "[key.value]".
     *
     * @param words is the String parameter to process.
     * @return the key value.
     */
    public static Object getSingleValue(String words) {
        String[] values = words.substring(words.indexOf('[') + 1, words.lastIndexOf(']')).split("\\.");
        return SharedVariableList.findAttribute(values[0], values[1]);
    }

    /**
     * This method return a rebuilt message.
     * Replaces the key and value identifiers enclosed in brackets with the corresponding value.
     * E.g: "The name is [Project1.name]" -> "The name is Automated".
     *
     * @param message the original message parameter.
     * @return the rebuilt message.
     */
    public static String rebuildMessage(String message) {
        String value = getSingleValue(message).toString();
        return message.replaceAll("(?=\\[)(.*?)(?<=])", value);
    }
}
