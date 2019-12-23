package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Option {
    public Option() {
    }

    @Expose
    @SerializedName("content")
    private String content;

    @Expose
    @SerializedName("is_right")
    private boolean isRight;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }
}
