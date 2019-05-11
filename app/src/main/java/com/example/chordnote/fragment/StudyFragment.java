package com.example.chordnote.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chordnote.activity.R;
import com.example.chordnote.domain.Book;
import com.example.chordnote.test.testItem;
import com.example.chordnote.domain.Period;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class StudyFragment extends Fragment
{

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    // 当前显示目录的Book，测试时new，正式时需要从本地读取Book对象
    private Book currentBook = new Book();

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public StudyFragment()
    {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static StudyFragment newInstance(int columnCount)
    {
        StudyFragment fragment = new StudyFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
        {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.study_fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView)
        {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1)
            {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else
            {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new StudyItemRecyclerViewAdapter(currentBook.getPeriodList(), mListener));
            recyclerView.addItemDecoration(new StudyItemDecoration(new StudyItemDecoration.OnTagListener()
            {
                @Override
                public String getChapter(int position)
                {
                    return currentBook.getPeriod(position).getChapterTitle();
                }

                @Override
                public boolean isChapterFirst(int position)
                {
                    // 判断当前Period的章节与上一个Period章节是否相同，如果不同则是一个章节的第一个课时
                    // 或者是开头第一个Period
                    if (position == 0 || !currentBook.getPeriod(position).getChapterTitle().
                            equals(currentBook.getPeriod(position - 1).getChapterTitle()))
                        return true;
                    else
                        return false;
                }
            }));
        }
        return view;
    }


    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener)
        {
            mListener = (OnListFragmentInteractionListener) context;
        } else
        {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener
    {
        // TODO: Update argument type and name
        void onListFragmentInteraction(testItem item);
    }
}
