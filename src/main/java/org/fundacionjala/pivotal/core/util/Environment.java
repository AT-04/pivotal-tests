package org.fundacionjala.pivotal.core.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by pivotal-test Team.
 */
public final class Environment {
    private static final String USERNAME = "username";
    private static final String PASS = "password";
    private static final String TOKEN = "token";
    private static final String BASE_URL = "baseurl";
    private static final String BROWSER = "browser";
    private static final String DOCKER_URL = "dockerurl";

    private static Environment instance;
    private Properties envProperties;

    /**
     * This is the constructor for the Environment class.
     */
    private Environment() {
        try (FileInputStream fileInputStream = new FileInputStream("gradle.properties")) {
            envProperties = new Properties();
            envProperties.load(fileInputStream);
        } catch (IOException e) {
            //Logger
            throw new RuntimeException(e);
        }
    }

    /**
     * This method return the singleton instance of the Environment class.
     *
     * @return the singleton instance.
     */
    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    /**
     * This method return the string for a specific environment property.
     *
     * @param env is the property string.
     * @return the specified property.
     */
    private String getEnv(final String env) {
        String property = System.getProperty(env);
        if (property == null) {
            return envProperties.getProperty(env);
        }
        return property;
    }

    /**
     * This method return the password from the environment properties.
     *
     * @return the password in a string object.
     */
    public String getPassword() {
        return getEnv(PASS);
    }

    /**
     * This method return the user from the environment properties.
     *
     * @return the user in a string object.
     */
    public String getUser() {
        return getEnv(USERNAME);
    }

    /**
     * This method return the restapi token from the environment properties.
     *
     * @return the token in a string object.
     */
    public String getToken() {
        return getEnv(TOKEN);
    }

    /**
     * This method return the base url from the environment properties.
     *
     * @return the base url in a string object.
     */
    public String getBaseUrl() {
        return getEnv(BASE_URL);
    }

    /**
     * This method return the user from the environment properties.
     *
     * @return the user in a string object.
     */
    public String getBrowser() {
        return getEnv(BROWSER);
    }

    /**
     * This method return the docker url from the environment properties.
     *
     * @return the user in a string object.
     */
    public String getDockerUrl() {
        return getEnv(DOCKER_URL);
    }
}
