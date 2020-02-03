package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class QuestionsResponse extends CommonResponse {
    public QuestionsResponse() {
    }

    @Expose
    @SerializedName("question_list")
    private List<Question> questionList;

    public ArrayList<Question> getQuestionList() {
        return new ArrayList<>(questionList);
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
