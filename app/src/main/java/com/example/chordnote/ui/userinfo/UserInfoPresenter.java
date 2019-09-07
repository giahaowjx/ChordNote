package com.example.chordnote.ui.userinfo;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;

import com.example.chordnote.ui.base.MvpPresenter;

import java.io.File;

public interface UserInfoPresenter<V extends UserInfoView> extends MvpPresenter<V> {

    void refreshUserInfo();

    void resetLoginState();

    void uploadHeadImg(Uri uri);

    void uploadUserName(String name);

    void uploadUserDesc(String desc);

    Uri iniImgFile(Context context);

    void saveBitmap(Context context, Uri uri);
}
