package com.example.chordnote.di.component;

import com.example.chordnote.di.module.ServiceModule;
import com.example.chordnote.di.scope.PerService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
}
