package com.example.chordnote.ui.booklist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chordnote.R;
import com.example.chordnote.data.network.model.Book;
import com.example.chordnote.ui.main.MainActivity;
import com.example.chordnote.ui.main.study.BookInfo;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private static final String TAG = "BookInfoAdapter";
    
    private Context mContext;

    private List<Book> bookList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        ImageView bookCover;
        TextView bookName;

        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view;
            bookCover = (ImageView) cardView.findViewById(R.id.book_cover_img);
            bookName = (TextView) cardView.findViewById(R.id.book_name_text);
        }
    }

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_book, parent, false);


        Log.d(TAG, "onCreateViewHolder: Chord");
        
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book bookInfo = bookList.get(position);

        holder.bookName.setText(bookInfo.getBookName());

        if (bookInfo.getBookProfileImg().length() > 0) {
            Glide.with(mContext)
                    .load(bookInfo.getBookProfileImg())
                    .into(holder.bookCover);
        } else {
            Glide.with(mContext)
                    .load(R.drawable.book_cover)
                    .into(holder.bookCover);
        }

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("bookId", bookList.get(position).getIdBook());
                ((Activity)v.getContext()).setResult(MainActivity.BOOK_ACTIVITY, intent);

                ((Activity)v.getContext()).finish();
            }
        });

        Log.d(TAG, "onBindViewHolder: Chord");
    }



    @Override
    public int getItemCount() {
        return bookList.size();
    }
}
