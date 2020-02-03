package com.example.chordnote.ui.period.question;

import com.example.chordnote.ui.base.MvpPresenter;

public interface QuestionPresenter<V extends QuestionView> extends MvpPresenter<V> {

    void setQuestionList(int idPeriod);

}
