package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckCodeRequest {

    public CheckCodeRequest(String email) {
        this.email = email;
    }

    @Expose
    @SerializedName("email")
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
