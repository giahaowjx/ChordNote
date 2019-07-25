package com.example.chordnote.data.prefs;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesHelperImpl implements PreferencesHelper {

    private SharedPreferences preferences;

    public PreferencesHelperImpl(Context context, String name) {
        preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    @Override
    public boolean getCurrentLoginState() {
        return preferences.getBoolean("login_state",false);
    }

    @Override
    public void setCurrentLoginState(boolean state) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("loginState",state);
        editor.apply();
    }

    @Override
    public Long getCurrentUserId() {
        return (Long)preferences.getLong("userId",0);
    }

    @Override
    public void setCurrentUserId(Long id) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong("userId",id);
        editor.apply();
    }

}
