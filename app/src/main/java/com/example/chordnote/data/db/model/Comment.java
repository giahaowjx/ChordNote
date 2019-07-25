package com.example.chordnote.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToOne;

@Entity(nameInDb = "comments")
public class Comment {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "comment_text")
    private String commentText;

    @Property(nameInDb = "user_id")
    private long userId;

    @ToOne(joinProperty = "userId")
    private User user;

    @Property(nameInDb = "period_id")
    private long periodId;

}
