package com.example.chordnote.di.module;

import android.app.Application;
import android.content.Context;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.db.DbHelper;
import com.example.chordnote.data.db.DbHelperImpl;
import com.example.chordnote.data.prefs.PreferencesHelper;
import com.example.chordnote.data.prefs.PreferencesHelperImpl;
import com.example.chordnote.di.ApplicationContext;
import com.example.chordnote.di.PreferenceInfo;
import com.example.chordnote.utils.AppSetting;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @PreferenceInfo
    String provideSharePreferencesName() {
        return AppSetting.PREFERENCES_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(PreferencesHelper preferencesHelper) {
        return new DataManager(preferencesHelper);
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper() {
        return new DbHelperImpl();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(@ApplicationContext Context context, @PreferenceInfo
                                               String name) {
        return new PreferencesHelperImpl(context,name);
    }

}
