package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Question {
    public Question() {
    }

    @Expose
    @SerializedName("id_question")
    private int idQuestion;

    @Expose
    @SerializedName("stem")
    private String stem;

    @Expose
    @SerializedName("image_url")
    private String ImgUrl;

    @Expose
    @SerializedName("option_list")
    private List<Option> optionList;

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getStem() {
        return stem;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public List<Option> getOptionList() {
        return optionList;
    }

    public void setOptionList(List<Option> optionList) {
        this.optionList = optionList;
    }
}
