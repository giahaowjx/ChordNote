package com.example.chordnote.ui.period.comment;

import com.example.chordnote.data.network.model.Comment;
import com.example.chordnote.ui.period.PeriodView;

import java.util.ArrayList;

public interface CommentView extends PeriodView {

    void setCommentList(ArrayList<Comment> comments);

}
