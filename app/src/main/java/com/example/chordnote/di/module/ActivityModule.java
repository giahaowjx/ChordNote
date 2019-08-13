package com.example.chordnote.di.module;


import android.provider.ContactsContract;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.login.LoginPresenter;
import com.example.chordnote.ui.login.LoginPresenterImpl;
import com.example.chordnote.ui.login.LoginView;
import com.example.chordnote.ui.main.me.MePresenter;
import com.example.chordnote.ui.main.me.MePresenterImpl;
import com.example.chordnote.ui.main.me.MeView;
import com.example.chordnote.ui.register.RegisterPresenter;
import com.example.chordnote.ui.register.RegisterPresenterImpl;
import com.example.chordnote.ui.register.RegisterView;
import com.example.chordnote.ui.splash.SplashPresenter;
import com.example.chordnote.ui.splash.SplashPresenterImpl;
import com.example.chordnote.ui.splash.SplashView;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    SplashPresenter<SplashView> provideSplashPresenter(DataManager manager) {
        return new SplashPresenterImpl<>(manager);
    }

    @Provides
    RegisterPresenter<RegisterView> provideRegisterPresenter(DataManager manager) {
        return new RegisterPresenterImpl<>(manager);
    }

    @Provides
    LoginPresenter<LoginView> provideLoginPresenter(DataManager manager) {
        return new LoginPresenterImpl<>(manager);
    }

    @Provides
    MePresenter<MeView> provideMePresenter(DataManager manager) {
        return new MePresenterImpl<>(manager);
    }

}
