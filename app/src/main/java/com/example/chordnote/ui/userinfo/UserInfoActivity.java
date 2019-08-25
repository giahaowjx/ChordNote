package com.example.chordnote.ui.userinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.widget.MeItemView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserInfoActivity extends BaseActivity implements UserInfoView {

    @BindView(R.id.user_info_item_head)
    MeItemView head;

    @BindView(R.id.user_info_item_name)
    MeItemView name;

    @BindView(R.id.user_info_item_email)
    MeItemView email;

    @BindView(R.id.user_info_item_sex)
    MeItemView sex;

    @BindView(R.id.user_info_item_birth_date)
    MeItemView birth;

    @BindView(R.id.user_info_item_description)
    MeItemView description;

    @BindView(R.id.logout_btn)
    Button logoutBtn;

    @Inject
    UserInfoPresenter<UserInfoView> presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        presenter.onAttach(this);

        ButterKnife.bind(this);

        presenter.getUserInfo();

    }

    @Override
    public void setUserUri(String uri) {
        head.setHead(uri);
    }

    @Override
    public void setUserName(String name) {
        this.name.setData(name);
    }

    @Override
    public void setUserEmail(String email) {
        this.email.setData(email);
    }

    @Override
    public void setUserSex(int sex) {
        if (sex == 1) {
            this.sex.setData("男");
        } else if (sex == 0) {
            this.sex.setData("女");
        } else {
            this.sex.setData("保密");
        }
    }

    @Override
    public void setUserDescription(String description) {
        this.description.setData(description);
    }

    @Override
    public void setUserBirthDate(String date) {
        this.birth.setData(date);
    }

    public static Intent getIntent(Context context) {
        return new Intent(context, UserInfoActivity.class);
    }

    @OnClick(R.id.logout_btn)
    public void onClickLogoutBtn(View view) {
        presenter.resetLoginState();

        Intent intent = new Intent();
        setResult(RESULT_OK, intent);

        finish();
    }

    @OnClick(R.id.user_info_item_head)
    public void onClickUserInfoItemHead(View view) {

    }
}
