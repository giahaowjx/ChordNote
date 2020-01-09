package com.example.chordnote.ui.period;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.chordnote.ui.base.BaseFragment;
import com.example.chordnote.ui.period.comment.CommentFragment;
import com.example.chordnote.ui.period.periodcontent.PeriodContentFragment;
import com.example.chordnote.ui.period.question.QuestionFragment;

import java.util.ArrayList;
import java.util.List;

public class PeriodPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_NUM = 3;
    private List<BaseFragment> fragments;
    private List<String> tabTitle;

    public PeriodPagerAdapter(@NonNull FragmentManager fm, List<BaseFragment> fragments, List<String> tabTitle) {
        super(fm);
        this.fragments = fragments;
        this.tabTitle = tabTitle;
    }

    @Override
    public Fragment getItem(int position){
        return fragments.get(position);
    }

    @Override
    public int getCount(){
        return PAGE_NUM;
    }

    @Override
    public CharSequence getPageTitle(int position){
        return tabTitle.get(position);
    }
}
