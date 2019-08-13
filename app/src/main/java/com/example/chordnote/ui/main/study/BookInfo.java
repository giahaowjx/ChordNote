package com.example.chordnote.ui.main.study;

public class BookInfo {

    private String bookName;

    private String bookCover;

    public BookInfo(String bookName, String bookCover) {
        this.bookName = bookName;
        this.bookCover = bookCover;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }
}
