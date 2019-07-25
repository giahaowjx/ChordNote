package com.example.chordnote.di.component;

import android.app.Application;
import android.content.Context;

import com.example.chordnote.ChordNoteApp;
import com.example.chordnote.data.DataManager;
import com.example.chordnote.di.ApplicationContext;
import com.example.chordnote.di.module.ApplicationModule;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(ChordNoteApp app);
}
