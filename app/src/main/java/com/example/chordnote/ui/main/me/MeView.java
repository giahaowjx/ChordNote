package com.example.chordnote.ui.main.me;

import com.example.chordnote.ui.base.MvpView;

public interface MeView extends MvpView {

    void openLoginActivity();

    void changeUserInfoView(String name, String uri);

    void openUserInfoActivity();

    void setUserEmail(String email);
}
