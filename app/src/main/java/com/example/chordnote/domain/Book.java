package com.example.chordnote.domain;

import java.util.ArrayList;
import java.util.List;

public class Book
{
    private String bookName;

    private ArrayList<Period> periodsList = new ArrayList<>();

    public Book()
    {
        // 暂时在代码中定义，后面在管理员处修改图书名字，加入Book(String name)构造方法
        bookName = "基本乐理知识";
        init(); // 用于测试
    }

    public void init()
    {
        char cha = 'A';
        for (int i = 0; i < 50; i++)
        {
            addPeriod("" + i, "" + cha);
            if (i % 6 == 0)
                cha ++;
        }
    }

    public final String getBookName()
    {
        // 获得书本名用于标题栏
        return bookName;
    }

    public void addPeriod(String title, String chapter)
    {
        periodsList.add(new Period(title, chapter));
    }

    public final Period getPeriod(int index)
    {
        if (index >= periodsList.size())
            return null;
        //获取Period实例传入Period碎片以及配合list长度显示目录
        return periodsList.get(index);
    }

    public int getPeriodListLength()
    {
        //获取PeriodList的长度用于目录显示
        return periodsList.size();
    }

    public final List<Period> getPeriodList()
    {
        return periodsList;
    }
}
