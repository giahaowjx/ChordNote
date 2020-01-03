package com.example.chordnote.ui.compose;

import com.example.chordnote.ui.base.MvpPresenter;
import com.example.chordnote.ui.base.MvpView;

import java.util.Map;

public interface ComposePresenter<V extends MvpView> extends MvpPresenter<V> {

    void sendCheckCode(String email);

    void register(Map<String, String> request);

}
