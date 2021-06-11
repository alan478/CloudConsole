package com.example.cloudconsole.ClassForAPI;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IamUserRegister {
    @SerializedName("key")
    public String key;
    @SerializedName("result")
    public List<String> result;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
