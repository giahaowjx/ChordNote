package com.example.chordnote.ui.login;

import android.os.Bundle;

import com.example.chordnote.ui.base.MvpView;

public interface LoginView extends MvpView {

    void openRegisterActivity();

    void loginSuccessfully(Bundle data);
}
