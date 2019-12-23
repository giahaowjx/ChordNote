package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DynamicsResponse extends CommonResponse {
    public DynamicsResponse() {
    }

    @Expose
    @SerializedName("data")
    private List<Dynamic> userDynamicList;

    @Expose
    @SerializedName("next")
    private String nextUrl;

    @Expose
    @SerializedName("previous")
    private String previousUrl;

    public String getNextUrl() {
        return nextUrl;
    }

    public void setNextUrl(String nextUrl) {
        this.nextUrl = nextUrl;
    }

    public String getPreviousUrl() {
        return previousUrl;
    }

    public void setPreviousUrl(String previousUrl) {
        this.previousUrl = previousUrl;
    }

    public List<Dynamic> getUserDynamicList() {
        return userDynamicList;
    }

    public void setUserDynamicList(List<Dynamic> userDynamicList) {
        this.userDynamicList = userDynamicList;
    }
}
