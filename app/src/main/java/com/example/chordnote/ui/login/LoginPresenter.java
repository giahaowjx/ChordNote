package com.example.chordnote.ui.login;

import com.example.chordnote.ui.base.MvpPresenter;
import com.example.chordnote.ui.base.MvpView;

public interface LoginPresenter<V extends MvpView> extends MvpPresenter<V> {

    void Login(String email, String password);



}
