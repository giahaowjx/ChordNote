package com.example.chordnote.ui.main.study;

import com.example.chordnote.ui.base.MvpView;

import java.util.List;

public interface StudyView extends MvpView {

    void showBookInfoList(List<BookInfo> bookInfoList);

}