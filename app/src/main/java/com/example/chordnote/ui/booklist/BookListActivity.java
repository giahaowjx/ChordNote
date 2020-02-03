package com.example.chordnote.ui.booklist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.chordnote.R;
import com.example.chordnote.data.network.model.Book;
import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.widget.CommonBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookListActivity extends BaseActivity implements BookListView {

    @Inject
    BookListPresenter<BookListView> presenter;

    @BindView(R.id.book_list_view)
    RecyclerView bookListRec;

    @BindView(R.id.booklist_commonbar)
    CommonBar bar;

    private ArrayList<Book> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        presenter.onAttach(this);

        bookListRec.setLayoutManager(new LinearLayoutManager(this));

        getSupportActionBar().hide();

        bar.setBarTitleText("书本清单");
    }

    public static Intent getIntent(Context context){
        return new Intent(context, BookListActivity.class);
    }

    @Override
    public void setBookList(ArrayList<Book> books) {
        this.books = books;

        bookListRec.setAdapter(new BookAdapter(books));
    }
}
