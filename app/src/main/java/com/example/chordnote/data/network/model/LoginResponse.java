package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    public LoginResponse() {

    }

    @Expose
    @SerializedName("code")
    private int statusCode;

    @Expose
    @SerializedName("email")
    private String userEmail;

    @Expose
    @SerializedName("user_name")
    private String userName;

    @Expose
    @SerializedName("msg")
    private String message;

    @Expose
    @SerializedName("user_pwd")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//
//    @Expose
//    @SerializedName("profile_pic_url")
//    private String profilePicUrl;

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }
}
