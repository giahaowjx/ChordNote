package com.example.chordnote.activity;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.chordnote.fragment.StudyFragment;
import com.example.chordnote.test.testItem;



public class MainActivity extends AppCompatActivity implements StudyFragment.OnListFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener()
    {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item)
        {
            switch (item.getItemId())
            {
                case R.id.navigation_compose:

                    return true;
                case R.id.navigation_study:
                    showStudyFragment();
                    return true;
                case R.id.navigation_discovery:

                    return true;
                case R.id.navigation_me:

                    return true;
            }
            return false;
        }
    };

    // 实现碎片中的接口
    @Override
    public void onListFragmentInteraction(testItem item)
    {
        Toast.makeText(MainActivity.this, "OK!" + item.toString(), Toast.LENGTH_LONG);
    }

    // 测试时用于启动学习碎片，后将放入继承接口类中
    private void showStudyFragment()
    {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, StudyFragment.newInstance(1));
        fragmentTransaction.commit();
    }

}
