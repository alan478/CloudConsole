package com.example.cloudconsole.ClassForAPI;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class IamUserAdditional implements Serializable {

    @SerializedName("id")
    int id;
    @SerializedName("iam_user_email")
    String iam_user_email;
    @SerializedName("user")
    int user;
    @SerializedName("root_user")
    int root_user;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIam_user_email() {
        return iam_user_email;
    }

    public void setIam_user_email(String iam_user_email) {
        this.iam_user_email = iam_user_email;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getRoot_user() {
        return root_user;
    }

    public void setRoot_user(int root_user) {
        this.root_user = root_user;
    }
}
