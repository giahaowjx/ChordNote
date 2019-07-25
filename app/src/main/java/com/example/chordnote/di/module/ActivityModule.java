package com.example.chordnote.di.module;


import androidx.appcompat.app.AppCompatActivity;

import dagger.Module;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }



}
