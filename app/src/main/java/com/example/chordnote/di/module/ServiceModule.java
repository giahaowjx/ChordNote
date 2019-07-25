package com.example.chordnote.di.module;

import android.app.Service;

import dagger.Module;

@Module
public class ServiceModule {

    private Service mService;

    public ServiceModule(Service service) {
        mService = service;
    }

}
