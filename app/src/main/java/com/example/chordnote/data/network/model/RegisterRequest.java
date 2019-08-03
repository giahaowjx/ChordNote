package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    public RegisterRequest(String email, String password, String checkCode, String name) {
        this.email = email;
        this.checkCode = checkCode;
        this.name = name;
        this.password = password;
    }

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("checkcode")
    private String checkCode;

    @Expose
    @SerializedName("user_pwd")
    private String password;

    @Expose
    @SerializedName("name")
    private String name;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
