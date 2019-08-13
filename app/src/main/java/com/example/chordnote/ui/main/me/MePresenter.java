package com.example.chordnote.ui.main.me;

import com.example.chordnote.data.db.model.User;
import com.example.chordnote.ui.base.MvpPresenter;

public interface MePresenter<V extends MeView> extends MvpPresenter<V> {

    void UpdateUserInfo(User user);

    void goNextActivity();

}
