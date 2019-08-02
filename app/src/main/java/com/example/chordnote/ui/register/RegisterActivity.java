package com.example.chordnote.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity implements RegisterView {

    private static final String TAG = "RegisterActivity";

    @Inject
    RegisterPresenter<RegisterView> presenter;

    @BindView(R.id.register_email_btn)
    EditText emailEdt;

    @BindView(R.id.register_checkcode_edt)
    EditText checkcodeEdt;

    @BindView(R.id.register_name_edt)
    EditText userNameEdt;

    @BindView(R.id.register_password_edt)
    EditText userPassEdt;

    @BindView(R.id.register_password_check_edt)
    EditText userPassCheckEdt;

    @BindView(R.id.register_btn)
    Button registerBtn;

    @BindView(R.id.send_checkcode_btn)
    Button sendCheckcodeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // ButterKnife 绑定控件
        ButterKnife.bind(this);

        // 注入presenter
        getActivityComponent().inject(this);

        presenter.onAttach(this);

    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, RegisterActivity.class);
        return intent;
    }

    @OnClick(R.id.send_checkcode_btn)
    public void onClickSendCheckCodeBtn(View view) {
        String email = emailEdt.getText().toString();

        if (email.length() <= 0) {
            Log.d(TAG, "onClickSendCheckCodeBtn: You shoud input your email");
        } else {
            Log.d(TAG, "onClickSendCheckCodeBtn: Click send checkcode");
            presenter.sendCheckCode(email);
        }

    }

}
