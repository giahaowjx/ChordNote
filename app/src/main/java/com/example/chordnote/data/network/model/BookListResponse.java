package com.example.chordnote.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class BookListResponse extends CommonResponse {
    public BookListResponse() {
    }

    @Expose
    @SerializedName("book_list")
    private List<Book> bookList;

    public ArrayList<Book> getBookList() {
        return new ArrayList<>(bookList);
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
