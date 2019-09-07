package com.example.chordnote.ui.userinfo;

import android.net.Uri;

import com.example.chordnote.ui.base.MvpView;

public interface UserInfoView extends MvpView {

    void setUserUri(String uri);

    void setUserName(String name);

    void setUserUri(Uri uri);

    void setUserUri();

    void setUserEmail(String email);

    void setUserSex(int sex);

    void setUserDescription(String description);

    void setUserBirthDate(String date);

    void isDirty(boolean yOrN);
}
