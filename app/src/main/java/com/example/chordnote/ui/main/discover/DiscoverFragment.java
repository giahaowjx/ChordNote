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
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DiscoverFragment extends BaseFragment implements DiscoverView {

//    public void init(){
//        test = new ArrayList<>();
//        Dynamic dynamic = new Dynamic();
//        dynamic.setContent("乐理好难学");
//        dynamic.setEmail("761497526@qq.com");
//        dynamic.setLikeNum(100);
//        dynamic.setNickName("giahao");
//        dynamic.setTitle("乐理真的难");
//        Dynamic dynamic1 = new Dynamic();
//        dynamic1.setContent("乐理好难学");
//        dynamic1.setEmail("761497526@qq.com");
//        dynamic1.setLikeNum(100);
//        dynamic1.setNickName("giahao");
//        dynamic1.setTitle("乐理真的难");
//        test.add(dynamic);
//        test.add(dynamic1);
//    }

    @BindView(R.id.dynamic_list_view)
    RecyclerView dynamicList;

    private ArrayList<Dynamic> dynamics;

    @Inject
    DiscoverPresenter<DiscoverView> presenter;

    @BindView(R.id.discover_floatingbutton)
    FloatingActionButton floatingActionButton;

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
        getActivityComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        // 碎片中需要解绑控件
        unbinder = ButterKnife.bind(this, view);

        presenter.getDynamics();

//        init();

        // 绑定presenter
        presenter.onAttach(this);

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
        super.onDetach();
        mListener = null;

        presenter.onDetach();
    }

    @Override
    public void setDynamicList(ArrayList<Dynamic> dynamics) {
        this.dynamics = dynamics;

        dynamicList.setAdapter(new DynamicAdapter(getActivity(), dynamics));
        dynamicList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
