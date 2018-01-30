package com.bsbs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * User.class is user data container.
 *
 * @author Volodymyr Severenchuk
 * Created on 1/30/2018
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String userName;
    private String userDescription;

    public User() {
    }

    public User(String userName, String userDescription) {
        this.userName = userName;
        this.userDescription = userDescription;
    }

    /**
     * Getter for user name.
     *
     * @return user name String value.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for user name.
     *
     * @param userName is user name String value.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for user description.
     *
     * @return user name String value.
     */
    public String getUserDescription() {
        return userDescription;
    }

    /**
     * Setter for user name.
     *
     * @param userDescription is user description String value.
     */
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

}
