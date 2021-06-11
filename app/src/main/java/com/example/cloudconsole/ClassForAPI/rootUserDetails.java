package com.example.cloudconsole.ClassForAPI;

import com.example.cloudconsole.ClassForAPI.userDetails;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class rootUserDetails implements Serializable {
    @SerializedName("user")
    public userDetails user;
    @SerializedName("token")
    public String token;

    public userDetails getUser() {
        return user;
    }

    public void setUser(userDetails user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
