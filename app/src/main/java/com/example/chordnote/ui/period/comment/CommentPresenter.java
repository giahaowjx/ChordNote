package com.example.chordnote.ui.period.comment;

import com.example.chordnote.ui.base.MvpPresenter;

public interface CommentPresenter<V extends CommentView> extends MvpPresenter<V> {

    void setCommentList(int idPeriod);

}
