package com.example.chordnote.ui.login;


import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

public class LoginPresenterImpl<V extends LoginView> extends BasePresenter<V> implements LoginPresenter<V> {

    public LoginPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }

    @Override
    public void Login(String email, String password) {

    }

}
