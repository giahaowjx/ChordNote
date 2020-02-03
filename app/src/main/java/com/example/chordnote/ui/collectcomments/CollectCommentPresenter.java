package com.example.chordnote.ui.collectcomments;

import com.example.chordnote.ui.base.MvpPresenter;

public interface CollectCommentPresenter<V extends CollectCommentView> extends MvpPresenter<V> {

    void setDynamicList(String email);

}
