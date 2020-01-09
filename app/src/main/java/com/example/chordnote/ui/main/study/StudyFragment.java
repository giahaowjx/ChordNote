package com.example.chordnote.ui.main.study;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.chordnote.R;
import com.example.chordnote.data.network.model.Chapter;
import com.example.chordnote.ui.base.BaseFragment;
import com.example.chordnote.ui.main.MainView;
import com.example.chordnote.ui.period.PeriodActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class StudyFragment extends BaseFragment implements StudyView {

    private static final String TAG = "StudyFragment";

    void init() {
            chapterList = new ArrayList<>();

            Chapter chapter = new Chapter();
            chapter.setTitle("基础理论");
            List<String> p = new ArrayList<>();
            p.add("音程");
            p.add("和弦和和弦的字母标记");
            p.add("声部进行的原则");
            p.add("和弦外音");
            int[] x = {0,1,2,3};
            chapter.setPeriodTitleList(p);
            chapter.setPeriodIdList(x);

            chapterList.add(chapter);

            Chapter chapter1 = new Chapter();
            chapter1.setTitle("流行音乐的和声");

            List<String> p1 = new ArrayList<>();
            p1.add("绪论");
            p1.add("第一章 功能和声的理论");
            p1.add("第二章 正、副和弦的进行方向");
            p1.add("第三章 离调进行");
            p1.add("第四章 小调的和弦进行");
            p1.add("第五章 终止进行");
            p1.add("第六章 和声进行的力度与模式");
            p1.add("第七章 转位低音与交替低音");
            p1.add("第八章 流行音乐的曲式");

            int[] x1 = {0,1,2,3,4,5,6,7,8};
            chapter1.setPeriodTitleList(p1);
            chapter1.setPeriodIdList(x1);

            chapterList.add(chapter1);
        }

    @BindView(R.id.book_list_rec)
    ExpandableListView bookListRec;

    @BindView(R.id.study_fragment_refresh)
    SwipeRefreshLayout studyFragmentRefresh;

    @Inject
    StudyPresenter<StudyView> presenter;

    private List<Chapter> chapterList;

    private OnFragmentInteractionListener mListener;

    private SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            presenter.refresh();
            studyFragmentRefresh.setRefreshing(false);
        }
    };

    public StudyFragment() {
    }

    public static StudyFragment newInstance() {
        StudyFragment fragment = new StudyFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);

        // 创建测试用适配器
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_study, container, false);

        unbinder = ButterKnife.bind(this, view);

        // 绑定presenter
        presenter.onAttach(this);

        PeriodListAdapter adapter = new PeriodListAdapter(getContext(), chapterList);

        // 为目录设置适配器
        bookListRec.setAdapter(adapter);
        bookListRec.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {

                return false;
            }
        });

        bookListRec.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                int count = adapter.getGroupCount();
                for (int j = 0; j < count; j++){
                    if (j != i){
                        bookListRec.collapseGroup(j);
                    }
                }
            }
        });

        bookListRec.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {

                // i 是目录下标，i1是child下标
                int periodId = adapter.getPeriodId(i, i1);

                Intent intent = PeriodActivity.getIntent(getActivity(), periodId);
                startActivity(intent);

                return false;
            }
        });

        presenter.refresh();

        // 设置刷新的颜色
        studyFragmentRefresh.setColorSchemeResources(R.color.colorPrimary);
        studyFragmentRefresh.setOnRefreshListener(refreshListener);

        return view;
    }

    public void setAdapter(List<Chapter> list) {
        this.chapterList = list;
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
        presenter.onDetach();
        mListener = null;
    }

    @Override
    public void showBookInfoList(List<Chapter> bookInfoList) {
        setAdapter(bookInfoList);
        bookListRec.setAdapter(new PeriodListAdapter(getContext(), chapterList));
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
