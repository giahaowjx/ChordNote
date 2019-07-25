package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @Expose
    @SerializedName("status_code")
    private int statusCode;

    @Expose
    @SerializedName("user_id")
    private Long userId;

    @Expose
    @SerializedName("user_num")
    private String userEmail;

    @Expose
    @SerializedName("user_name")
    private String userName;

    @Expose
    @SerializedName("token")
    private String Token;

    @Expose
    @SerializedName("msg")
    private String message;

    @Expose
    @SerializedName("profile_pic_url")
    private String profilePicUrl;

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setToken(String token) {
        Token = token;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getToken() {
        return Token;
    }

    public String getMessage() {
        return message;
    }
}
