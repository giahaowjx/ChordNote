package com.example.chordnote.ui.mydynamics;

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

public class MyDynamicActivity extends BaseActivity {

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

    private RecyclerView myDynamics;

    private CommonBar bar;

    private ArrayList<Dynamic> dynamics;

    @Inject
    MyDynamicPresenter<MyDynamicView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dynamic);

        init();

        myDynamics = findViewById(R.id.my_dynamic_list_view);
        myDynamics.setLayoutManager(new LinearLayoutManager(this));
        myDynamics.setAdapter(new DynamicAdapter(this, dynamics));

        getSupportActionBar().hide();

        bar = findViewById(R.id.my_dynamic_commonbar);
        bar.setBarTitleText("我的动态");
    }

    public static Intent getIntent(Context context){
        return new Intent(context, MyDynamicActivity.class);
    }
}
