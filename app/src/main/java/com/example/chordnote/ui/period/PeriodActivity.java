package com.example.chordnote.ui.period;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toolbar;

import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.base.BaseFragment;
import com.example.chordnote.ui.period.comment.CommentFragment;
import com.example.chordnote.ui.period.periodcontent.PeriodContentFragment;
import com.example.chordnote.ui.period.question.QuestionFragment;
import com.example.chordnote.ui.register.RegisterActivity;
import com.example.chordnote.ui.widget.CommonBar;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PeriodActivity extends BaseActivity implements PeriodView {

    @Inject
    PeriodPresenter<PeriodView> presenter;

    @BindView(R.id.period_tablayout)
    TabLayout tabLayout;

    @BindView(R.id.period_commonbar)
    CommonBar commonBar;

    private int periodId;

    private PeriodPagerAdapter adapter;

    @BindView(R.id.period_viewpager)
    ViewPager viewPager;

    private CommentFragment commentFragment;
    private PeriodContentFragment periodContentFragment;
    private QuestionFragment questionFragment;

    private String periodTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        periodId = intent.getIntExtra("id", 0);
        periodTitle = intent.getStringExtra("title");

        periodContentFragment = new PeriodContentFragment();
        questionFragment = QuestionFragment.newInstance(periodId);
        commentFragment = CommentFragment.newInstance(periodId);

        List<BaseFragment> fragments = new ArrayList<>();
        List<String> tabTitle = new ArrayList<>();

        tabTitle.add("课时内容");
        tabTitle.add("习题");
        tabTitle.add("评论");

        fragments.add(periodContentFragment);
        fragments.add(questionFragment);
        fragments.add(commentFragment);

        adapter = new PeriodPagerAdapter(getSupportFragmentManager(), fragments, tabTitle);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        commonBar.setBarTitleText(periodTitle);
    }

    public static Intent getIntent(Context context, int id, String periodTitle) {
        Intent intent = new Intent(context, PeriodActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("title", periodTitle);
        return intent;
    }
}
