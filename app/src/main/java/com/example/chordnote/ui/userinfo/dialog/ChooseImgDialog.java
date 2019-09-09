package com.example.chordnote.ui.userinfo.dialog;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.chordnote.R;
import com.example.chordnote.ui.base.BaseDialog;
import com.example.chordnote.ui.userinfo.UserInfoActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

public class ChooseImgDialog extends BaseDialog {

    private static final String TAG = "ChooseImgDialog";

    @BindView(R.id.choose_image_camera)
    CircleImageView cameraCircleImg;

    @BindView(R.id.choose_image_photo)
    CircleImageView photoCircleImg;

    @BindView(R.id.choose_image_cancel)
    Button cancelBtn;

    private OnClickListener listener;

    private Context context;

    private int themeResId;

    public ChooseImgDialog(@NonNull Context context, int themeResId, OnClickListener listener) {
        this.context = context;
        this.themeResId = themeResId;
        this.listener = listener;


    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_choose_image, container, false);

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void setUp(View view) {

    }

    @OnClick(R.id.choose_image_cancel)
    public void onClickCancelBtn(View view) {
        unbinder.unbind();
        dismiss();
    }

    @OnClick(R.id.choose_image_camera)
    public void onClickCameraBtn(View view) {
        if (listener != null) {
            listener.onClickCameraBtn();
        }
    }

    @OnClick(R.id.choose_image_photo)
    public void onClickAlbumBtn(View view) {
        if (listener != null) {
            listener.onClickAlbumBtn();
        }
    }

    public interface OnClickListener {
        void onClickCameraBtn();

        void onClickAlbumBtn();
    }

}
