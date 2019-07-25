package com.example.chordnote.data.db.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.time.Period;
import java.util.List;


@Entity(nameInDb = "books")
public class Book {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    @Property(nameInDb = "book_name")
    private String bookName;

    @Property(nameInDb = "cover_img_url")
    private String coverImgUrl;

    @ToMany(referencedJoinProperty = "bookId")
    private List<Period> periodList;
}
