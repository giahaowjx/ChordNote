package com.example.chordnote.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.chordnote.R;
import com.example.chordnote.ui.login.LoginActivity;
import com.example.chordnote.ui.main.MainActivity;


public class SplashActivity extends AppCompatActivity implements SplashMvpView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
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


}
