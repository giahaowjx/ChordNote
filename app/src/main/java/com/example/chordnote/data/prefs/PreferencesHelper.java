package com.example.chordnote.data.prefs;

public interface PreferencesHelper {

    boolean getCurrentLoginState();

    void setCurrentLoginState(boolean state);

    String getCurrentUserEmail();

    void setCurrentUserEmail(String email);

    String getCurrentUserNickName();

    void setCurrentUserNickName(String name);

    String getCurrentUserPass();

    void setCurrentUserPass(String password);

    void setEmailToIdMap(String email, long id);

    Long getIdUsingEmail(String email);

    void deleteEmailToIdMap(String email);

    void resetCurrentLoginInfo();

}
