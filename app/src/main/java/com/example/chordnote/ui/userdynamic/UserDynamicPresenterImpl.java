package com.example.chordnote.ui.userdynamic;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class UserDynamicPresenterImpl<V extends UserDynamicView> extends BasePresenter<V> implements UserDynamicPresenter<V> {

    @Inject
    public UserDynamicPresenterImpl(DataManager manager) {
        super(manager);
    }
}
