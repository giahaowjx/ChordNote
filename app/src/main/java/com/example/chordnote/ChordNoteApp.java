package com.example.chordnote;

import android.app.Application;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.di.component.ApplicationComponent;
import com.example.chordnote.di.module.ApplicationModule;

import javax.inject.Inject;

public class ChordNoteApp extends Application {

    @Inject
    DataManager manager;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

//        mApplicationComponent = DaggerApplicationComponent.builder()
//                .applicationModule(new ApplicationModule(this)).build();
//
//        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

}
