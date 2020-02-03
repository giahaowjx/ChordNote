package com.example.chordnote.ui.period.comment;

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
import com.example.chordnote.data.network.model.Comment;
import com.example.chordnote.data.network.model.Dynamic;
import com.example.chordnote.ui.base.BaseFragment;
import com.example.chordnote.ui.main.discover.DynamicAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommentFragment extends BaseFragment implements CommentView {

//    public void init(){
//        comments = new ArrayList<>();
//        Comment dynamic = new Comment();
//        dynamic.setContent("乐理好难学");
//        dynamic.setEmail("761497526@qq.com");
//        dynamic.setLikeNum(100);
//        dynamic.setNickName("giahao");
//        Comment dynamic1 = new Comment();
//        dynamic1.setContent("乐理好难学");
//        dynamic1.setEmail("761497526@qq.com");
//        dynamic1.setLikeNum(100);
//        dynamic1.setNickName("giahao");
//        comments.add(dynamic);
//        comments.add(dynamic1);
//    }

    @Inject
    CommentPresenter<CommentView> presenter;

    @BindView(R.id.comment_list_view)
    RecyclerView commentList;

    private ArrayList<Comment> comments;

    private int idPeriod;

    private OnFragmentInteractionListener mListener;

    public CommentFragment() {
        // Required empty public constructor
    }


    public static CommentFragment newInstance(int idPeriod) {
        CommentFragment fragment = new CommentFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("idPeriod", idPeriod);
        fragment.setArguments(bundle);

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
        View view = inflater.inflate(R.layout.fragment_comment, container, false);

        // 碎片中需要解绑控件
        unbinder = ButterKnife.bind(this, view);

        // 绑定presenter
        presenter.onAttach(this);

        // 获取课时id
        Bundle bundle = this.getArguments();
        if (bundle != null){
            idPeriod = bundle.getInt("idPeriod");

            // 设置评论
            presenter.setCommentList(idPeriod);
        }
//        init();

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
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

        presenter.onDetach();
    }

    @Override
    public void setCommentList(ArrayList<Comment> comments) {
        this.comments = comments;

        commentList.setAdapter(new CommentAdapter(getActivity(), comments));
        commentList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
