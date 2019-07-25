package com.example.chordnote.data.prefs;

public interface PreferencesHelper {

    boolean getCurrentLoginState();

    void setCurrentLoginState(boolean state);

    Long getCurrentUserId();

    void setCurrentUserId(Long id);

}
