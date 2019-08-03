package com.example.chordnote.ui.register;

import com.example.chordnote.ui.base.MvpPresenter;
import com.example.chordnote.ui.base.MvpView;

import java.util.Map;

public interface RegisterPresenter<V extends MvpView> extends MvpPresenter<V> {

    void sendCheckCode(String email);

    void register(Map<String, String> request);

}
