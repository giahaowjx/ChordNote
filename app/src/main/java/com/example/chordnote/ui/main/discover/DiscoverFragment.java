package com.example.chordnote.ui.main.discover;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chordnote.R;
import com.example.chordnote.data.network.model.Dynamic;
import com.example.chordnote.ui.base.BaseFragment;
import com.example.chordnote.ui.main.MainView;

import java.util.ArrayList;

import javax.inject.Inject;

<<<<<<< Updated upstream
public class DiscoverFragment extends BaseFragment implements DiscoverView {
=======
import butterknife.BindView;

public class DiscoverFragment extends BaseFragment implements MainView {
>>>>>>> Stashed changes

    public void init(){
        test = new ArrayList<>();
        Dynamic dynamic = new Dynamic();
        dynamic.setContent("乐理好难学");
        dynamic.setEmail("761497526@qq.com");
        dynamic.setLikeNum(100);
        dynamic.setNickName("giahao");
        dynamic.setTitle("乐理真的难");
        Dynamic dynamic1 = new Dynamic();
        dynamic1.setContent("乐理好难学");
        dynamic1.setEmail("761497526@qq.com");
        dynamic1.setLikeNum(100);
        dynamic1.setNickName("giahao");
        dynamic1.setTitle("乐理真的难");
        test.add(dynamic);
        test.add(dynamic1);
    }

    //@BindView(R.id.dynamic_list_view)
    RecyclerView dynamicList;

    private ArrayList<Dynamic> test;

    @Inject
    DiscoverPresenter<DiscoverView> presenter;

    private OnFragmentInteractionListener mListener;

    public DiscoverFragment() {
        // Required empty public constructor
    }


    public static DiscoverFragment newInstance(String param1, String param2) {
        DiscoverFragment fragment = new DiscoverFragment();
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
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        dynamicList = view.findViewById(R.id.dynamic_list_view);
        init();
        dynamicList.setAdapter(new DynamicAdapter(getActivity(), test));
        dynamicList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    public static void plusGoodNum(int dynamicId){

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
