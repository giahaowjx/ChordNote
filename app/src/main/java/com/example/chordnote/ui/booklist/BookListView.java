package com.example.chordnote.ui.booklist;

import com.example.chordnote.data.network.model.Book;
import com.example.chordnote.ui.base.MvpView;

import java.util.ArrayList;

public interface BookListView extends MvpView {

    void setBookList(ArrayList<Book> books);

}
