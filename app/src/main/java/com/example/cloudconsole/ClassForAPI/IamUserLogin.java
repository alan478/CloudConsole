package com.example.cloudconsole.ClassForAPI;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class IamUserLogin implements Serializable {
    @SerializedName("user")
    IamUserDetails user;

    @SerializedName("token")
    String token;

    public IamUserDetails getUser() {
        return user;
    }

    public void setUser(IamUserDetails user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
