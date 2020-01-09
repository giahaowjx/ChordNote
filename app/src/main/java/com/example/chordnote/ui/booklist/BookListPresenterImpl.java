package com.example.chordnote.ui.booklist;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class BookListPresenterImpl<V extends BookListView> extends BasePresenter<V> implements BookListPresenter<V> {

    @Inject
    public BookListPresenterImpl(DataManager manager) {
        super(manager);
    }
}
