package com.example.chordnote.ui.userinfo;

import com.example.chordnote.ui.base.MvpPresenter;

public interface UserInfoPresenter<V extends UserInfoView> extends MvpPresenter<V> {

    void getUserInfo();

    void resetLoginState();

}
