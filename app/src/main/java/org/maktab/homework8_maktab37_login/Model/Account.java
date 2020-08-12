package org.maktab.homework8_maktab37_login.Model;

import java.io.Serializable;

public class Account implements Serializable {
    private int mPassword;
    private String mUsername;

    public int getPassword() {
        return mPassword;
    }

    public void setPassword(int password) {
        mPassword = password;
    }

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(String username) {
        mUsername = username;
    }
}
