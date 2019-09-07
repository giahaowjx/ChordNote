package com.example.chordnote.data.network.model;

import com.example.chordnote.data.db.model.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInformationResponse {

    @Expose
    @SerializedName("code")
    private int code;

    @Expose
    @SerializedName("msg")
    private String message;

    @Expose
    @SerializedName("user_information")
    private User userInformation;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(User userInformation) {
        this.userInformation = userInformation;
    }
}
