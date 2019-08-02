package com.example.chordnote.ui.register;

import com.example.chordnote.ui.base.MvpPresenter;
import com.example.chordnote.ui.base.MvpView;

public interface RegisterPresenter<V extends MvpView> extends MvpPresenter<V> {

    void sendCheckCode(String email);

    void register(String email, String name, String password);

}
