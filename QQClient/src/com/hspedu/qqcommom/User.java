package com.hspedu.qqcommom;

import java.io.Serializable;

/**
 * This class is used to represent a user.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String passwd;

    public User(String userId, String passwd) {
        this.userId = userId;
        this.passwd = passwd;
    }
    public String getUserId() {
        return userId;
    }
    public String getPasswd() {
        return passwd;
    }
}
