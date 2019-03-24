package com.example.chordnote.ui;

import android.app.Activity;
import android.content.Intent;

import com.example.chordnote.activity.MainActivity;

public class UIHelper
{
    static public void showMain(Activity context)
    {
        Intent intent = new Intent(context, MainActivity.class);
    }
}
