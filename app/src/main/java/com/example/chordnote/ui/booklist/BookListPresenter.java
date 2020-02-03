package com.example.chordnote.ui.booklist;

import com.example.chordnote.ui.base.MvpPresenter;
import com.example.chordnote.ui.base.MvpView;

public interface BookListPresenter<V extends MvpView> extends MvpPresenter<V> {

    void getBookList();

}
