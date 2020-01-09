package com.example.chordnote.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.chordnote.R;
import androidx.annotation.NonNull;

import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.main.compose.ComposeFragment;
import com.example.chordnote.ui.main.discover.DiscoverFragment;
import com.example.chordnote.ui.main.me.MeFragment;
import com.example.chordnote.ui.main.study.StudyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainView, ComposeFragment.OnFragmentInteractionListener
, StudyFragment.OnFragmentInteractionListener, DiscoverFragment.OnFragmentInteractionListener,
MeFragment.OnFragmentInteractionListener{

    private static final String TAG = "MainActivity";
    
    @BindView(R.id.nav_view)
    BottomNavigationView navigation;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    private MenuItem menuItem;

    private Menu bookMenu;

    // 底部导航栏的监听器实例
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_compose:
                    viewPager.setCurrentItem(0);
                    getSupportActionBar().setTitle(R.string.title_compose);
                    bookMenu.setGroupVisible(0, false);
                    return true;
                case R.id.navigation_study:
                    viewPager.setCurrentItem(1);
                    getSupportActionBar().setTitle(R.string.title_study);
                    bookMenu.setGroupVisible(0, true);
                    return true;
                case R.id.navigation_discover:
                    viewPager.setCurrentItem(2);
                    getSupportActionBar().setTitle(R.string.title_discovery);
                    bookMenu.setGroupVisible(0, false);
                    return true;
                case R.id.navigation_me:
                    viewPager.setCurrentItem(3);
                    getSupportActionBar().setTitle(R.string.title_me);
                    bookMenu.setGroupVisible(0, false);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        // 初始化适配器来初始化Viewpager
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(ComposeFragment.newInstance("ChordNote","ChordNote"));
        adapter.addFragment(StudyFragment.newInstance());
        adapter.addFragment(DiscoverFragment.newInstance("ChordNote","ChordNote"));
        adapter.addFragment(MeFragment.newInstance(Long.valueOf(100)));

        // 给viewpager设置适配器并把首页设置在学习界面
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        navigation.setSelectedItemId(R.id.navigation_study);
        getSupportActionBar().setTitle(R.string.title_study);

        // 给导航栏添加监听器监听点击事件
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // 给viewpager添加监听器处理事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    //此方法的作用是创建一个选项菜单，我们要重写这个方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        bookMenu = menu;
        //加载菜单文件
        getMenuInflater().inflate(R.menu.study_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //这里是一个switch语句,主要通过menu文件中的id值来确定点了哪个菜单，然后做对应的操作，这里的menu是指你加载的那个菜单文件
        switch (item.getItemId()) {
            case R.id.study_booklist:
                // 获取书本列表。打开书本列表activity
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onFragmentInteraction(Uri uri) {
        showToastText("onFragmentInteraction");
    }

}
