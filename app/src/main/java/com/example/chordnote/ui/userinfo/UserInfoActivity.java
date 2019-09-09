package com.example.chordnote.ui.userinfo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.userinfo.dialog.ChooseImgDialog;
import com.example.chordnote.ui.widget.MeItemView;


import java.util.Calendar;

import javax.inject.Inject;
import javax.net.ssl.ManagerFactoryParameters;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserInfoActivity extends BaseActivity implements UserInfoView {

    private static final String TAG = "UserInfoActivity";

    public final static int CAMERA = 1;

    public final static int ALBUM = 2;

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

    private ChooseImgDialog imgDialog;

    @Inject
    UserInfoPresenter<UserInfoView> presenter;

    private Uri imgUri;

    private boolean isDirty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        getActivityComponent().inject(this);

        presenter.onAttach(this);

        ButterKnife.bind(this);

        presenter.refreshUserInfo();

        getSupportActionBar().hide();

        isDirty = false;

    }

    @Override
    public void setUserUri(String uri) {
        head.setHead(uri);
    }

    @Override
    public void setUserUri(Uri uri) {
        head.setHead(uri);
    }

    @Override
    public void setUserUri() {
        head.setHead();
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
        } else if (sex == 2) {
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
        intent.putExtra("isDirty", isDirty);
        intent.putExtra("isLogout", true);
        setResult(RESULT_OK, intent);

        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();

        Intent intent = new Intent();
        intent.putExtra("isDirty", isDirty);
        intent.putExtra("isLogout", false);
        setResult(RESULT_OK, intent);

        finish();
    }

    @OnClick(R.id.user_info_item_head)
    public void onClickUserInfoItemHead(View view) {
         imgDialog = new ChooseImgDialog(this, R.layout.dialog_choose_image,
                new ChooseImgDialog.OnClickListener() {
                    @Override
                    public void onClickCameraBtn() {
                        // 先设置好用户拍摄图片的存储位置
                        imgUri = presenter.iniImgFile(UserInfoActivity.this);

                        Log.d(TAG, "onClickCameraBtn: " + imgUri);

                        openCamera();
                    }

                    @Override
                    public void onClickAlbumBtn() {
                        Log.d(TAG, "onClickAlbumBtn: ");

                        if (ContextCompat.checkSelfPermission(UserInfoActivity.this,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.
                                PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(UserInfoActivity.this, new
                                    String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                        } else {
                            openAlbum();
                        }
                    }
                });

        imgDialog.show(getSupportFragmentManager(), TAG);
    }

    public void openCamera() {
        // 启动拍照界面
        Intent intent = new Intent();
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);

        Log.d(TAG, "openCamera: " + intent.toString());

        startActivityForResult(intent, CAMERA);
    }

    public void openAlbum() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        startActivityForResult(intent, ALBUM);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
                    showToastText("请允许应用拥有写外存的权限");
                }
                break;
            default:
        }
    }

    @OnClick(R.id.user_info_item_name)
    public void onClickUserInfoItemName(View view) {
        final EditText edit = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入新昵称")
                .setView(edit)
                .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 选择保存后上传更新后的用户信息
                        String name = edit.getText().toString();
                        if (name == null) {
                            showToastText("请输入用户名");
                        } else {
                            presenter.uploadUserName(name);
                        }

                        dialog.dismiss();
                    }
                }).setNegativeButton("取消", null).show();
    }

    @OnClick(R.id.user_info_item_sex)
    public void onClickUserInfoItemSex(View view) {

    }

    @OnClick(R.id.user_info_item_description)
    public void onClickUserInfoItemDesc(View view) {
        final EditText edit = new EditText(this);
        new AlertDialog.Builder(this).setTitle("请输入")
                .setView(edit)
                .setPositiveButton("保存", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 保存用户的个人签名
                        String desc = edit.getText().toString();
                        if (desc.length() == 0) {
                            showToastText("请输入个人签名");
                        } else {
                            presenter.uploadUserDesc(desc);
                        }

                        dialog.dismiss();
                    }
                }).show();
    }

    @OnClick(R.id.user_info_item_birth_date)
    public void onClickUserInfoItemBirth(View view) {
        String date = birth.getData();

        // 日期时间
        int year, month, day;

        if (date.length() > 0) {
            // 获取用户的生日日期
            String[] dateInfo = date.split("/");

            year = Integer.valueOf(dateInfo[0]);
            month = Integer.valueOf(dateInfo[1]);
            day = Integer.valueOf(dateInfo[2]);
        } else {
            // 用户没有设置过生日，默认先显示当前的日期
            Calendar calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
        }

        // 调用时间选择器
        new DatePickerDialog(UserInfoActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // 设置了日期后上传用户的生日然后更新界面
                presenter.uploadUserBirth(year + "/" + month + "/" + dayOfMonth);


            }
        }, year, month, day).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        Log.d(TAG, "onActivityResult: 1");
        super.onActivityResult(requestCode, resultCode, data);

        Log.d(TAG, "onActivityResult: 2" + requestCode);
        switch (requestCode) {
            case CAMERA:
                if (resultCode == RESULT_OK) {
                    // 将获取的文件保存
//                    presenter.saveBitmap(UserInfoActivity.this, imgUri);
                    Log.d(TAG, "onActivityResult: after save bitmap");
                    // 上传新头像
                    presenter.uploadHeadImg(imgUri);

                    // 关闭对话框
                    imgDialog.dismissDialog(TAG);
                }
                break;
            case ALBUM:
                if (resultCode == RESULT_OK) {

                    Log.d(TAG, "onActivityResult: before upload head img from album" + data.getData());

                    presenter.uploadHeadImg(data.getData());

                    imgDialog.dismissDialog(TAG);
                }
                break;
            default:
                break;
        }
    }

    // 上传新头像
    public void uploadHeadImg() {
        presenter.uploadHeadImg(imgUri);
    }



    @Override
    public void isDirty(boolean yOrN) {
        isDirty = yOrN;
    }
}
