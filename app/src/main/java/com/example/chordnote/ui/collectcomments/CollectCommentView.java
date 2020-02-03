package com.example.chordnote.ui.collectcomments;

import com.example.chordnote.data.network.model.Comment;
import com.example.chordnote.ui.base.MvpView;

import java.util.ArrayList;

public interface CollectCommentView extends MvpView {

    void setDynamicList(ArrayList<Comment> comments);

}
