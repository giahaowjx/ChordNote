package com.example.chordnote.DataBase;

import android.support.annotation.Nullable;

import org.litepal.annotation.Column;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Lesson_Table extends DataSupport {
    //Title
    private int id;

    private String classChapter;

    private String classSection;

    private String lessonName;


    //文字简介

    private String classIntroduction;

    //题目,与problem有联系

    private List<Practice_Table> thisSectionProblems;

    public String getClassChapter() {
        return classChapter;
    }

    public void setClassChapter(String classChapter) {
        this.classChapter = classChapter;
    }

    public String getClassSection() {
        return classSection;
    }

    public void setClassSection(String classSection) {
        this.classSection = classSection;
    }


    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String className) {
        this.lessonName = lessonName;
    }

    public String getClassIntroduction() {
        return classIntroduction;
    }

    public void setClassIntroduction(String classIntroduction) {
        this.classIntroduction = classIntroduction;
    }

    public List<Practice_Table> getThisSectionProblems() {
        return thisSectionProblems;
    }

    public void setThisSectionProblems(List<Practice_Table> thisSectionProblems) {
        this.thisSectionProblems = thisSectionProblems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
