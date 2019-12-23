package com.example.chordnote.ui.main.study;

import com.example.chordnote.ui.base.MvpPresenter;

public interface StudyPresenter<V extends StudyView> extends MvpPresenter<V> {

    void refresh();

    // 显示书本列表
    void getBookList();

    // 显示书本目录信息
    void getChapterList(int idBook);
}
