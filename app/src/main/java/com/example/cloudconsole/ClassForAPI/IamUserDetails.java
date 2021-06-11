package com.example.cloudconsole.ClassForAPI;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class IamUserDetails implements Serializable {
    @SerializedName("id")
    int id;
    @SerializedName("iamuseradditional")
    IamUserAdditional iamuseradditional;
    @SerializedName("last_login")
    String last_login;
    @SerializedName("is_superuser")
    Boolean is_superuser;
    @SerializedName("name")
    String name;
    @SerializedName("is_staff")
    Boolean is_staff;
    @SerializedName("is_active")
    Boolean is_active;
    @SerializedName("date_joined")
    String date_joined;
    @SerializedName("type")
    String type;
    @SerializedName("groups")
    List<String> groups;
    @SerializedName("permissions")
    List<String> permissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IamUserAdditional getIamuseradditional() {
        return iamuseradditional;
    }

    public void setIamuseradditional(IamUserAdditional iamuseradditional) {
        this.iamuseradditional = iamuseradditional;
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

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
