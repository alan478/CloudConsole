package com.example.cloudconsole.ClassForAPI;

import android.widget.LinearLayout;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class user {
    @SerializedName("result")
    public List<String > result;

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
