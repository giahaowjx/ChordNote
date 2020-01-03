package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Chapter {
    public Chapter() {
    }

    @Expose
    @SerializedName("id_chapter")
    private int idChapter;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("period_title_list")
    private List<String> periodTitleList;

    @Expose
    @SerializedName("period_id_list")
    private int[] periodIdList;

    public int getIdChapter() {
        return idChapter;
    }

    public void setIdChapter(int idChapter) {
        this.idChapter = idChapter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPeriodTitleList() {
        return periodTitleList;
    }

    public void setPeriodTitleList(List<String> periodTitleList) {
        this.periodTitleList = periodTitleList;
    }

    public int[] getPeriodIdList() {
        return periodIdList;
    }

    public void setPeriodIdList(int[] periodIdList) {
        this.periodIdList = periodIdList;
    }
}
