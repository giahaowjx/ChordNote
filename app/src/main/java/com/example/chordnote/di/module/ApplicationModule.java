package com.example.chordnote.di.module;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.db.DbHelper;
import com.example.chordnote.data.db.DbHelperImpl;
import com.example.chordnote.data.db.DbOpenHelper;
import com.example.chordnote.data.db.model.DaoMaster;
import com.example.chordnote.data.db.model.DaoSession;
import com.example.chordnote.data.network.ApiHelper;
import com.example.chordnote.data.network.ApiHelperImpl;
import com.example.chordnote.data.prefs.PreferencesHelper;
import com.example.chordnote.data.prefs.PreferencesHelperImpl;
import com.example.chordnote.di.ApplicationContext;
import com.example.chordnote.di.DatabaseInfo;
import com.example.chordnote.di.PreferenceInfo;
import com.example.chordnote.utils.AppSetting;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

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
    DataManager provideDataManager(PreferencesHelper preferencesHelper, ApiHelper apiHelper, DbHelper dbHelper) {
        return new DataManager(preferencesHelper, apiHelper, dbHelper);
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(DbOpenHelper helper) {
        return new DbHelperImpl(helper);
    }

    @Provides
    @Singleton
    DbOpenHelper provideDbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String name) {
        return new DbOpenHelper(context, name);
    }

    @Provides
    @Singleton
    @DatabaseInfo
    String provideDataBaseName() {
        return "chordnote";
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper() {
        return new ApiHelperImpl();
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(@ApplicationContext Context context, @PreferenceInfo
            String name) {
        return new PreferencesHelperImpl(context,name);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient();
    }


}
