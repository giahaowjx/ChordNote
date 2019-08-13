package com.example.chordnote.ui.main.study;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseFragment;
import com.example.chordnote.ui.main.MainView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StudyFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StudyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudyFragment extends BaseFragment implements MainView {

    private OnFragmentInteractionListener mListener;

    @BindView(R.id.book_list_rec)
    RecyclerView bookListRec;

    public StudyFragment() {
    }

    public static StudyFragment newInstance(String param1, String param2) {
        StudyFragment fragment = new StudyFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study, container, false);

        unbinder = ButterKnife.bind(this, view);

        // 为RecyclerView添加Manager设置两列，设置适配器
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        bookListRec.setLayoutManager(layoutManager);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
