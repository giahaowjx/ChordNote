package com.example.chordnote.ui.main.compose;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class ComposePresenterImpl<V extends ComposeView> extends BasePresenter<V> implements ComposePresenter<V> {
    @Inject
    public ComposePresenterImpl(DataManager manager) {
        super(manager);
    }

    //TODO
}
