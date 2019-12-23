package com.example.chordnote.ui.main.discover;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class DiscoverPresenterImpl<V extends DiscoverView> extends BasePresenter<V> implements DiscoverPresenter<V> {
    @Inject
    public DiscoverPresenterImpl(DataManager manager) {
        super(manager);
    }

    // TODO
}
