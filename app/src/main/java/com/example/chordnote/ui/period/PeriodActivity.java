package com.example.chordnote.ui.period;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.register.RegisterActivity;

import javax.inject.Inject;

public class PeriodActivity extends BaseActivity implements PeriodView {

    @Inject
    PeriodPresenter<PeriodView> presenter;

    private int periodId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_period);

        Intent intent = getIntent();
        periodId = intent.getIntExtra("id", 0);
    }

    public static Intent getIntent(Context context, int id) {
        Intent intent = new Intent(context, PeriodActivity.class);
        intent.putExtra("id", id);
        return intent;
    }
}
