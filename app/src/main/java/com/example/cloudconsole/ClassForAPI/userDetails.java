package com.example.cloudconsole.ClassForAPI;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class userDetails implements Serializable {
    @SerializedName("id")
    public int id;
    @SerializedName("password")
    public String password;
    @SerializedName("last_login")
    public String last_login;
    @SerializedName("is_superuser")
    public Boolean is_superuser;
    @SerializedName("username")
    public String username;
    @SerializedName("email")
    public String email;
    @SerializedName("name")
    public String name;
    @SerializedName("is_staff")
    public Boolean is_staff;
    @SerializedName("is_active")
    public Boolean is_active;
    @SerializedName("date_joined")
    public String date_joined;
    @SerializedName("type")
    public String type;
    @SerializedName("groups")
    public List<String> groups;
    @SerializedName("user_permissions")
    public List<String> user_permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public Boolean getIs_superuser() {
        return is_superuser;
    }

    public void setIs_superuser(Boolean is_superuser) {
        this.is_superuser = is_superuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIs_staff() {
        return is_staff;
    }

    public void setIs_staff(Boolean is_staff) {
        this.is_staff = is_staff;
    }

    public Boolean getIs_active() {
        return is_active;
    }

    public void setIs_active(Boolean is_active) {
        this.is_active = is_active;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public List<String> getUser_permissions() {
        return user_permissions;
    }

    public void setUser_permissions(List<String> user_permissions) {
        this.user_permissions = user_permissions;
    }
}
