package com.example.chordnote.ui.main.me;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.db.model.User;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class MePresenterImpl<V extends MeView> extends BasePresenter<V> implements MePresenter<V> {

    @Inject
    public MePresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void UpdateUserInfo(User user) {

    }

    @Override
    public void goNextActivity() {
        if (!getDataManager().getCurrentLoginState()) {
            getMvpView().openLoginActivity();
        }
    }
}
