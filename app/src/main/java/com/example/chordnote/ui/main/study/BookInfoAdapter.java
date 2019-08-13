package com.example.chordnote.ui.main.study;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.chordnote.R;

import java.util.List;

public class BookInfoAdapter extends RecyclerView.Adapter<BookInfoAdapter.ViewHolder> {

    private Context mContext;

    private List<BookInfo> bookInfoList;

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

    public BookInfoAdapter(List<BookInfo> bookInfoList) {
        this.bookInfoList = bookInfoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.book_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BookInfo bookInfo = bookInfoList.get(position);
        holder.bookName.setText(bookInfo.getBookName());
        Glide.with(mContext)
                .load(bookInfo.getBookCover())
                .into(holder.bookCover);
    }

    @Override
    public int getItemCount() {
        return bookInfoList.size();
    }
}
