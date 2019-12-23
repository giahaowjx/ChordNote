package com.example.chordnote.ui.period;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.chordnote.R;

import javax.inject.Inject;

public class PeriodActivity extends AppCompatActivity {

    @Inject
    private PeriodPresenter<PeriodView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period);
    }
}
