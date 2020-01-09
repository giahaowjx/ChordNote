package com.example.chordnote.di.module;


import android.content.Context;
import android.provider.ContactsContract;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.di.ActivityContext;
import com.example.chordnote.ui.collectDynamics.CollectDynamicPresenter;
import com.example.chordnote.ui.collectDynamics.CollectDynamicPresenterImpl;
import com.example.chordnote.ui.collectDynamics.CollectDynamicView;
import com.example.chordnote.ui.login.LoginPresenter;
import com.example.chordnote.ui.login.LoginPresenterImpl;
import com.example.chordnote.ui.login.LoginView;
import com.example.chordnote.ui.main.discover.DiscoverPresenter;
import com.example.chordnote.ui.main.discover.DiscoverPresenterImpl;
import com.example.chordnote.ui.main.discover.DiscoverView;
import com.example.chordnote.ui.main.me.MePresenter;
import com.example.chordnote.ui.main.me.MePresenterImpl;
import com.example.chordnote.ui.main.me.MeView;
import com.example.chordnote.ui.main.study.StudyPresenter;
import com.example.chordnote.ui.main.study.StudyPresenterImpl;
import com.example.chordnote.ui.main.study.StudyView;
import com.example.chordnote.ui.myDynamics.MyDynamicPresenter;
import com.example.chordnote.ui.myDynamics.MyDynamicPresenterImpl;
import com.example.chordnote.ui.myDynamics.MyDynamicView;
import com.example.chordnote.ui.period.PeriodPresenter;
import com.example.chordnote.ui.period.PeriodPresenterImpl;
import com.example.chordnote.ui.period.PeriodView;
import com.example.chordnote.ui.register.RegisterPresenter;
import com.example.chordnote.ui.register.RegisterPresenterImpl;
import com.example.chordnote.ui.register.RegisterView;
import com.example.chordnote.ui.splash.SplashPresenter;
import com.example.chordnote.ui.splash.SplashPresenterImpl;
import com.example.chordnote.ui.splash.SplashView;
import com.example.chordnote.ui.usercomment.UserCommentPresenter;
import com.example.chordnote.ui.usercomment.UserCommentPresenterImpl;
import com.example.chordnote.ui.usercomment.UserCommentView;
import com.example.chordnote.ui.userdynamic.UserDynamicPresenter;
import com.example.chordnote.ui.userdynamic.UserDynamicPresenterImpl;
import com.example.chordnote.ui.userdynamic.UserDynamicView;
import com.example.chordnote.ui.userinfo.UserInfoPresenter;
import com.example.chordnote.ui.userinfo.UserInfoPresenterImpl;
import com.example.chordnote.ui.userinfo.UserInfoView;

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

    @Provides
    StudyPresenter<StudyView> provideStudyPresenter(DataManager manager) {
        return new StudyPresenterImpl<>(manager);
    }

    @Provides
    UserInfoPresenter<UserInfoView> provideUserInfoPresenter(@ActivityContext Context context, DataManager manager) {
        return new UserInfoPresenterImpl<>(context, manager);
    }

    @Provides
    DiscoverPresenter<DiscoverView> provideDiscoverPresenter(DataManager manager){
        return new DiscoverPresenterImpl<>(manager);
    }

    @Provides
    PeriodPresenter<PeriodView> providePeriodPresenter(DataManager manager){
        return new PeriodPresenterImpl<>(manager);
    }

    @Provides
    CollectDynamicPresenter<CollectDynamicView> provideCollectDynamicPresenter(DataManager manager){
        return new CollectDynamicPresenterImpl<>(manager);
    }

    @Provides
    MyDynamicPresenter<MyDynamicView> provideMyDynamicPresenter(DataManager manager){
        return new MyDynamicPresenterImpl<>(manager);
    }

    @Provides
    @ActivityContext
    Context provideActivityContext() {
        return mActivity;
    }

}
