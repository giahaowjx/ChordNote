package com.example.chordnote.ui.booklist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.chordnote.R;

import javax.inject.Inject;

public class BookListActivity extends AppCompatActivity {

    @Inject
    BookListPresenter<BookListView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
    }

    public static Intent getIntent(Context context){
        return new Intent(context, BookListActivity.class);
    }
}
