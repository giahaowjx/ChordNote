package com.example.chordnote.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

@Entity(nameInDb = "periods")
class Period {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    @Property(nameInDb = "book_id")
    private long bookId;

    @NotNull
    @Property(nameInDb = "period_name")
    private String title;

    @Property(nameInDb = "chapter_name")
    private String chapterName;

    @ToMany(referencedJoinProperty = "periodId")
    private List<Question> questionList;

    @ToMany(referencedJoinProperty = "periodId")
    private List<Comment> commentList;

}
