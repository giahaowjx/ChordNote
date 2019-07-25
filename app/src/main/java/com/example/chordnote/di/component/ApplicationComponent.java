package com.example.chordnote.di.component;

import com.example.chordnote.ChordNoteApp;
import com.example.chordnote.di.module.ApplicationModule;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(ChordNoteApp app);
}
