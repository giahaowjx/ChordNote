package com.example.chordnote.test;

import com.example.chordnote.activity.R;

public class testItem
{
    private String name;

    private int ImageId;

    public testItem(String name)
    {
        this.name = name;
        ImageId = R.mipmap.ic_launcher;
    }

    public String getName()
    {
        return name;
    }

    public int getImageId()
    {
        return ImageId;
    }
}
