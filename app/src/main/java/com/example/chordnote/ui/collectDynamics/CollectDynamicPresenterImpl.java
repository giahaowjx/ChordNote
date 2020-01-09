package com.example.chordnote.ui.collectdynamics;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class CollectDynamicPresenterImpl<V extends CollectDynamicView> extends BasePresenter<V> implements CollectDynamicPresenter<V> {
    @Inject
    public CollectDynamicPresenterImpl(DataManager manager) {
        super(manager);
    }
}
