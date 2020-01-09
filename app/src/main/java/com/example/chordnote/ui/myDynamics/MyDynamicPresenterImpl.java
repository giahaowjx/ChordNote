package com.example.chordnote.ui.mydynamics;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class MyDynamicPresenterImpl<V extends MyDynamicView> extends BasePresenter<V> implements MyDynamicPresenter<V> {

    @Inject
    public MyDynamicPresenterImpl(DataManager manager) {
        super(manager);
    }

}
