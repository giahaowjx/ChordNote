package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Book {
    public Book() {
    }

    @Expose
    @SerializedName("id_book")
    private int idBook;

    @Expose
    @SerializedName("book_name")
    private String bookName;

    @Expose
    @SerializedName("profile_photo_url")
    private String bookProfileImg;

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookProfileImg() {
        return bookProfileImg;
    }

    public void setBookProfileImg(String bookProfileImg) {
        this.bookProfileImg = bookProfileImg;
    }
}
