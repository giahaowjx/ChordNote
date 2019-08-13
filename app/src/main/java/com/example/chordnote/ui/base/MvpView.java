package com.example.chordnote.ui.base;

import androidx.annotation.StringRes;

public interface MvpView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    void showToastText(String string);
}
