package com.example.chordnote.DataBase;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Practice_Table extends DataSupport {
    //根据对应章节号访问数据库

    private int ID;//某一章节的某一小节内，第几题
    //需要写入数据库的内容
    private boolean completed;//是否完成
    private boolean collected;//是否收藏

    private boolean correctOrNot;//是否做对
    String notes;//做了什么笔记

    //需要从数据库中读出的内容
    private char correctAnswer;//正确答案是什么
    private String problem;//题目的字面描述
    //可附加音频和图片
    private List<String> options;//选项的字面描述
    //也可附加音频和图片

    private Lesson_Table lesson;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean isCollected() {
        return collected;
    }

    public void setCollected(boolean collected) {
        this.collected = collected;
    }

    public boolean isCorrectOrNot() {
        return correctOrNot;
    }

    public void setCorrectOrNot(boolean correctOrNot) {
        this.correctOrNot = correctOrNot;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public char getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(char correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public Lesson_Table getLesson() {
        return lesson;
    }

    public void setLesson(Lesson_Table lesson) {
        this.lesson = lesson;
    }
}
