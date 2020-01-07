package com.example.chordnote.ui.usercomment;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class UserCommentPresenterImpl<V extends UserCommentView> extends BasePresenter<V> implements UserCommentPresenter<V> {

    @Inject
    public UserCommentPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

}
