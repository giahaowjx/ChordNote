package com.example.chordnote.ui.main.study;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class StudyPresenterImpl<V extends StudyView> extends BasePresenter<V> implements StudyPresenter<V> {

    @Inject
    public StudyPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void refresh() {
        return;
    }
}
