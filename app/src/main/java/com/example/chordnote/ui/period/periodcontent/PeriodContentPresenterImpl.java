package com.example.chordnote.ui.period.periodcontent;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class PeriodContentPresenterImpl<V extends PeriodContentView> extends BasePresenter<V> implements PeriodContentPresenter<V> {

    @Inject
    public PeriodContentPresenterImpl(DataManager manager) {
        super(manager);
    }
}
