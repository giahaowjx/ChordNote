package com.example.chordnote.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;

@Entity(nameInDb = "options")
public class Option {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "option_text")
    private String optionText;

    @NotNull
    @Property(nameInDb = "question_id")
    private long questionId;

    @Property(nameInDb = "is_correct")
    private boolean isCorrect;

    @Property(nameInDb = "option_img_url")
    private String imgUrl;

}
