package com.example.chordnote.ui.userinfo;

import com.example.chordnote.ui.base.MvpView;

public interface UserInfoView extends MvpView {

    void setUserUri(String uri);

    void setUserName(String name);

    void setUserEmail(String email);

    void setUserSex(int sex);

    void setUserDescription(String description);

    void setUserBirthDate(String date);

}
