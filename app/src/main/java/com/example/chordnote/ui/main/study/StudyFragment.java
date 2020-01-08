package com.example.chordnote.ui.main.study;

import android.content.Context;
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
import com.example.chordnote.ui.base.BaseFragment;
import com.example.chordnote.ui.main.MainView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

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
public class StudyFragment extends BaseFragment implements StudyView {

    // 测试用
    PeriodListAdapter list;

    private static final String TAG = "StudyFragment";

    void init() {
        //存放组列表，每个组都要有一个对应的子列表，否则出错
        List<Map<String, String>> groups = new ArrayList<>();
        Map<String, String> group1 = new HashMap<>();
        group1.put("group", "group1");//键，组名
        Map<String, String> group2 = new HashMap<>();
        group2.put("group", "group2");
        groups.add(group1);//加入第一个组
        groups.add(group2);//加入第二个组


        //一个子列表
        List<Map<String, String>> child1 = new ArrayList<>();
        Map<String, String> child1Date1 = new HashMap<>();
        child1Date1.put("child", "child1Date1");
        Map<String, String> child1Date2 = new HashMap<>();
        child1Date2.put("child", "child1Date2");
        child1.add(child1Date1);//子列表第一项
        child1.add(child1Date2);//子列表第二项

        //一个子列表
        List<Map<String, String>> child2 = new ArrayList<>();
        Map<String, String> child2Date1 = new HashMap<>();
        child2Date1.put("child", "child2Date1");
        Map<String, String> child2Date2 = new HashMap<>();
        child2Date2.put("child", "child2Date2");
        child2.add(child2Date1);//子列表第一项
        child2.add(child2Date2);//子列表第二项

        //存放所有组的子列表
        List<List<Map<String, String>>> childs = new ArrayList<>();
        childs.add(child1);//第一个组的子列表
        childs.add(child2);//第二个组的子列表

        //创建适配器（Activity，组列表，组布局文件，组名键值对键，布局中组名显示位置
        // 子列表，子列表布局文件，子列表项键值对键，布局中子列表项内容显示位置）
        list = new PeriodListAdapter(
                getContext(), groups, R.layout.group_study, new String[]{"group"}, new int[]{R.id.item_group_study},
                childs, R.layout.child_study, new String[]{"child"}, new int[]{R.id.item_child_study});
    }

    @BindView(R.id.book_list_rec)
    ExpandableListView bookListRec;

    @BindView(R.id.study_fragment_refresh)
    SwipeRefreshLayout studyFragmentRefresh;

    @Inject
    StudyPresenter<StudyView> presenter;

    private BookInfoAdapter adapter;

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

        // 为目录设置适配器
        bookListRec.setAdapter(list);
        bookListRec.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                showToastText(((TextView) view.findViewById(R.id.item_child_study)).getText().toString());

                return false;
            }
        });

        presenter.refresh();

        // 设置刷新的颜色
        studyFragmentRefresh.setColorSchemeResources(R.color.colorPrimary);
        studyFragmentRefresh.setOnRefreshListener(refreshListener);

        return view;
    }

    public void setAdapter(List<BookInfo> list) {
        this.adapter = new BookInfoAdapter(list);
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
    public void showBookInfoList(List<BookInfo> bookInfoList) {

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
