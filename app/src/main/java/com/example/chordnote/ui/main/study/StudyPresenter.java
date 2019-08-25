package com.example.chordnote.ui.main.study;

import com.example.chordnote.ui.base.MvpPresenter;

public interface StudyPresenter<V extends StudyView> extends MvpPresenter<V> {

    void refresh();



}
