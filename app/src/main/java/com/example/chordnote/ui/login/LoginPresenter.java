package com.example.chordnote.ui.login;

import com.example.chordnote.ui.base.MvpPresenter;
import com.example.chordnote.ui.base.MvpView;

import java.util.Map;

public interface LoginPresenter<V extends MvpView> extends MvpPresenter<V> {

    void Login(Map<String, String> request);

}
