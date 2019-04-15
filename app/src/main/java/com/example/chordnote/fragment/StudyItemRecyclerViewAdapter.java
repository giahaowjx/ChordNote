package com.example.chordnote.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chordnote.activity.R;
import com.example.chordnote.fragment.StudyFragment.OnListFragmentInteractionListener;
import com.example.chordnote.test.testItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link testItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class StudyItemRecyclerViewAdapter extends RecyclerView.Adapter<StudyItemRecyclerViewAdapter.ViewHolder>
{

    private final List<testItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public StudyItemRecyclerViewAdapter(List<testItem> items, OnListFragmentInteractionListener listener)
    {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.study_fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position)
    {
        testItem item = mValues.get(position);
        holder.testImage.setImageResource(item.getImageId());
        holder.testText.setText(item.getName());
    }

    @Override
    public int getItemCount()
    {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public final View mView;
        public final ImageView testImage;
        public final TextView testText;

        public ViewHolder(View view)
        {
            super(view);
            mView = view;
            testImage = (ImageView) view.findViewById(R.id.test_image);
            testText = (TextView) view.findViewById(R.id.test_text);
        }

        @Override
        public String toString()
        {
            return super.toString();
        }
    }
}
