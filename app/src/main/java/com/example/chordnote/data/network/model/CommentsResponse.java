package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CommentsResponse extends CommonResponse {
    public CommentsResponse() {
    }

    @Expose
    @SerializedName("data")
    private List<Comment> commentList;

    public ArrayList<Comment> getCommentList() {
        return new ArrayList<>(commentList);
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
