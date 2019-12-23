package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Comment {
    public Comment() {
    }

    @Expose
    @SerializedName("id_comment")
    private int idComment;

    @Expose
    @SerializedName("like_num")
    private int likeNum;

    @Expose
    @SerializedName("content")
    private String content;

    @Expose
    @SerializedName("email")
    private String email;

    @Expose
    @SerializedName("nickname")
    private String nickName;

    @Expose
    @SerializedName("image_url")
    private String headImgUrl;

    @Expose
    @SerializedName("publiched_time")
    private String publishedTime;

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(String publishedTime) {
        this.publishedTime = publishedTime;
    }
}
