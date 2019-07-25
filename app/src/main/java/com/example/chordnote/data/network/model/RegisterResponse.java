package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    private RegisterResponse() {

    }

    @Expose
    @SerializedName("code")
    private int statusCode;

    @Expose
    @SerializedName("msg")
    private String message;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("user_pwd")
    private String password;

    @Expose
    @SerializedName("user_name")
    private String userName;

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }
}
