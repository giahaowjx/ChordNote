package com.example.chordnote.domain;

import java.util.ArrayList;

public class Period
{
    private boolean finished;

    // 课时名字
    private String periodTitle;

    // 章节名字，用于目录显示时悬浮标签判断是否到下一章节
    private String chapterTitle;

    private ArrayList<Resource> resourceList = new ArrayList<>();

    // 每个课时的题目
    private ArrayList<Question> quiz = new ArrayList<>();

    public Period()
    {
        finished = false;
        periodTitle = null;
        chapterTitle = null;
    }

    public Period(String period, String chapter)
    {
        finished = false;
        periodTitle = period;
        chapterTitle = chapter;
    }

    public final String getPeriodTitle()
    {
        return periodTitle;
    }

    public final String getChapterTitle()
    {
        return chapterTitle;
    }

    public boolean isFinished()
    {
        return finished;
    }

    public void addResource(Resource resource)
    {
        resourceList.add(resource);
    }

    public final Resource getResource(int index)
    {
        if (index >= resourceList.size())
            return null;
        // 获得对应资源，用于课时内容的显示
        return resourceList.get(index);
    }

    public void deleteResource(int index)
    {
        if (index >= resourceList.size())
            return;
        resourceList.remove(index);
    }

    public void finish()
    {
        finished = true;
    }

   public int getResourcesNumber()
   {
       // 获取资源的数量，用于遍历资源列表
       return resourceList.size();
   }

   public void addQuestion(Question question)
   {
       quiz.add(question);
   }

   public final Question getQuestion(int index)
   {
       if (index >= quiz.size())
           return null;
       return quiz.get(index);
   }

   public void deleteQuestion(int index)
   {
       if (index >= quiz.size())
           return;
       quiz.remove(index);
   }
}
