package com.example.chordnote.di.component;

import com.example.chordnote.di.module.ActivityModule;
import com.example.chordnote.di.scope.PerActivity;
import com.example.chordnote.ui.login.LoginActivity;
import com.example.chordnote.ui.main.MainActivity;
import com.example.chordnote.ui.main.me.MeFragment;
import com.example.chordnote.ui.register.RegisterActivity;
import com.example.chordnote.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

    void inject(MainActivity activity);

    void inject(RegisterActivity activity);

    void inject(MeFragment fragment);

}
