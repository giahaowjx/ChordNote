package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterRequest {

    private RegisterRequest() {

    }

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("user_pwd")
    private String password;

    @Expose
    @SerializedName("checkcode")
    private String checkCode;

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
}
