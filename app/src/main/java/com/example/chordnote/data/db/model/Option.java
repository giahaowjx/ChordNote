package com.example.chordnote.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

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

    @Generated(hash = 1611717034)
    public Option(Long id, String optionText, long questionId, boolean isCorrect,
            String imgUrl) {
        this.id = id;
        this.optionText = optionText;
        this.questionId = questionId;
        this.isCorrect = isCorrect;
        this.imgUrl = imgUrl;
    }

    @Generated(hash = 104107376)
    public Option() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOptionText() {
        return this.optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public long getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public boolean getIsCorrect() {
        return this.isCorrect;
    }

    public void setIsCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
