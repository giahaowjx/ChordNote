package com.example.chordnote.ui.collectdynamics;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.chordnote.R;
import com.example.chordnote.data.network.model.Dynamic;
import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.main.discover.DynamicAdapter;
import com.example.chordnote.ui.widget.CommonBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectDynamicActivity extends BaseActivity implements CollectDynamicView {

    public void init(){
        dynamics = new ArrayList<>();
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
        dynamics.add(dynamic);
        dynamics.add(dynamic1);
    }

    @BindView(R.id.collect_dynamic_list_view)
    RecyclerView colllectDynamics;

    @BindView(R.id.collect_dynamic_commonbar)
    CommonBar bar;

    private ArrayList<Dynamic> dynamics;

    private String email;

    @Inject
    CollectDynamicPresenter<CollectDynamicView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_dynamic);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        presenter.onAttach(this);

        colllectDynamics.setLayoutManager(new LinearLayoutManager(this));

        email = getIntent().getStringExtra("email");
        if (email != null){
            presenter.setDynamicList(email);
        }

//        init();


        getSupportActionBar().hide();

        bar.setBarTitleText("收藏动态");
    }

    public static Intent getIntent(Context context, String email){
        Intent intent = new Intent(context, CollectDynamicActivity.class);

        intent.putExtra("email", email);

        return intent;
    }

    @Override
    public void setDynamicList(ArrayList<Dynamic> dynamics) {
        this.dynamics = dynamics;

        colllectDynamics.setAdapter(new DynamicAdapter(this, dynamics));
    }
}
