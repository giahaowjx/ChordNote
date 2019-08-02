package com.example.chordnote.ui.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.login.LoginActivity;
import com.example.chordnote.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SplashActivity extends BaseActivity implements SplashView {

    private static final String TAG = "SplashActivity";
    
    @Inject
    SplashPresenter<SplashView> presenter;

    @BindView(R.id.logo_img)
    ImageView logoImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        logoImage.setImageResource(R.mipmap.study);

        Log.d(TAG, "onCreate: balabala 1");

        getActivityComponent().inject(this);

        Log.d(TAG, "onCreate: balabala 2");

        presenter.onAttach(this);

        onDestroy();

    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context,SplashActivity.class);
        return intent;
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getIntent(SplashActivity.this);
        startActivity(intent);
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getIntent(SplashActivity.this);
        startActivity(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

}
