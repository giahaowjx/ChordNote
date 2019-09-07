package com.example.chordnote.ui.base;

import androidx.annotation.StringRes;

import java.io.File;

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showToastText(String string);

    boolean isConnected();

    File getCacheDir();
}
