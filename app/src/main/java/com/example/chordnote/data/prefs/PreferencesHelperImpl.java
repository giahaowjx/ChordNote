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
        return preferences.getBoolean("loginState",false);
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

    @Override
    public String getCurrentUserEmail() {
        return preferences.getString("currentEmail", " ");
    }

    @Override
    public void setCurrentUserEmail(String email) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("currentEmail", email);
        editor.apply();
    }

    @Override
    public String getCurrentUserPass() {
        return preferences.getString("currentPass", " ");
    }

    @Override
    public void setCurrentUserPass(String password) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("currentPass", password);
        editor.apply();
    }

    @Override
    public void setEmailToIdMap(String email, long id) {
        if (getIdUsingEmail(email) != 0) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putLong(email, id);
            editor.apply();
        }
    }

    @Override
    public Long getIdUsingEmail(String email) {
        return (Long)preferences.getLong(email, 0);
    }

    @Override
    public void deleteEmailToIdMap(String email) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(email);
        editor.apply();
    }

    @Override
    public void resetCurrentLoginInfo() {
        setCurrentLoginState(false);
        setCurrentUserEmail(" ");
        setCurrentUserId((long)0);
        setCurrentUserPass(" ");
    }
}
