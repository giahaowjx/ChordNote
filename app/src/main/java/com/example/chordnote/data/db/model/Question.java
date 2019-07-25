package com.example.chordnote.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;


@Entity(nameInDb = "questions")
public class Question {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "period_id")
    private long periodId;

    @Property(nameInDb = "question_text")
    private String questionText;

    @Property(nameInDb = "question_img_url")
    private String imgUrl;

    @ToMany(referencedJoinProperty = "questionId")
    private List<Option> optionList;
}
