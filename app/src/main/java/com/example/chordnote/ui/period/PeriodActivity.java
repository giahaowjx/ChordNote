package com.example.chordnote.ui.period;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseActivity;

import javax.inject.Inject;

public class PeriodActivity extends BaseActivity implements PeriodView {

    @Inject
    PeriodPresenter<PeriodView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period);
    }
}
