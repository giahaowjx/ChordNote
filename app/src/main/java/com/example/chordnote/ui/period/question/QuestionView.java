package com.example.chordnote.ui.period.question;

import com.example.chordnote.data.network.model.Question;
import com.example.chordnote.ui.period.PeriodView;

import java.util.ArrayList;

public interface QuestionView extends PeriodView {

    void setQuestionList(ArrayList<Question> questions);

}
