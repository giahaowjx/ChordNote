package com.example.chordnote.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.register.RegisterActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {

    @BindView(R.id.user_email_edit)
    EditText emailEdt;

    @BindView(R.id.user_pass_edit)
    EditText passwordEdt;

    @BindView(R.id.user_login_btn)
    Button loginBtn;

    @BindView(R.id.user_forget_pass_btn)
    Button forgetPassBtn;

    @BindView(R.id.user_register_btn)
    Button registerBtn;

    @Inject
    LoginPresenter<LoginView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 绑定控件
        ButterKnife.bind(this);

        // 注入presenter
        getActivityComponent().inject(this);

    }

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context,LoginActivity.class);
        return intent;
    }

    @Override
    public void openRegisterActivity() {
        Intent intent = RegisterActivity.getIntent(LoginActivity.this);
        startActivity(intent);
    }

    @OnClick(R.id.user_register_btn)
    public void onClickRegisterBtn(View view) {
        openRegisterActivity();
    }

    @OnClick(R.id.user_forget_pass_btn)
    public void onClickForgetPassBtn(View view) {

    }

    @OnClick(R.id.user_login_btn)
    public void onClickLoginBtn(View view) {

    }

}
