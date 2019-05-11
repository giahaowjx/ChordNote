package com.example.chordnote.domain;

import java.util.ArrayList;
import java.util.List;

public class Question
{
    // 题面
    private String questionContent;

    // 选项
    private ArrayList<String> choices = new ArrayList<>();

    // 答案,将答案的下标
    private ArrayList<Integer> solution = new ArrayList<>();

    // 问题类型，用于加载不同题型对应的题目界面
    // 0 - 单选， 1 - 多选， 2 - 判断， 3 - 不定项（可拓展）
    private short questionType;

    public Question()
    {
        questionContent = "";
        questionType = 0;
    }

    public boolean answer(List<Integer> solution)
    {
        // 如果长度不同，答案不全，回答错误
        if (this.solution.size() != solution.size())
            return false;
        else
        {
            // 判断是否每个输入的solution的元素都是答案
            for (int i = 0; i < solution.size(); i++)
            {
                if (!this.solution.contains(solution.get(i)))
                    return false;
            }
            return true;
        }
    }

    public void setQuestionContent(String content)
    {
        questionContent = content;
    }

    // 添加选项，不能重复添加相同选项
    public boolean addChoice(String choice)
    {
        if (choices.contains(choice))
            return false;
        choices.add(choice);
        return true;
    }

    // 添加答案，不能重复添加同一选项作为答案，且选项下标不能超过答案下标
    public boolean addSolution(Integer index)
    {
        if (solution.contains(index))
            return false;
        else if (index >= choices.size())
            return false;
        solution.add(index);
        return true;
    }

    public void deleteChoice(int index)
    {
        if (index >= choices.size())
            return;
        choices.remove(index);
    }

    // 注意：使用元素下标删除，不是答案选项下标
    public void deleteSolution(int index)
    {
        if (index >= solution.size())
            return;
        solution.remove(index);
    }

    public final String getQuestionContent()
    {
        return questionContent;
    }

    public final int getQuestionType()
    {
        return questionType;
    }

    public final String getChoice(int index)
    {
        if (index >= choices.size())
            return null;
        return choices.get(index);
    }

    public int getChoicesLength()
    {
        return choices.size();
    }
}
