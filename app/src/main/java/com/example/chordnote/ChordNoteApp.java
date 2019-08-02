package com.example.chordnote;

import android.app.Application;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.di.component.ApplicationComponent;
import com.example.chordnote.di.component.DaggerApplicationComponent;
import com.example.chordnote.di.module.ApplicationModule;

import javax.inject.Inject;

import okhttp3.OkHttpClient;

public class ChordNoteApp extends Application {

    @Inject
    DataManager manager;

    @Inject
    OkHttpClient client;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    public DataManager getDataManager() {return manager;}

    public OkHttpClient getOkHttpClient() {
        return client;
    }

}
