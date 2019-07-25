package com.example.chordnote.di.component;

import com.example.chordnote.di.module.ActivityModule;
import com.example.chordnote.di.scope.PerActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
}
