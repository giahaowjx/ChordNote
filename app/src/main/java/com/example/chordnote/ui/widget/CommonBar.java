package com.example.chordnote.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.chordnote.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CommonBar extends FrameLayout {

    @BindView(R.id.bar_return_btn)
    ImageButton barReturnBtn;

    @BindView(R.id.bar_title_text)
    TextView barTitleText;

    @BindView(R.id.bar_more_btn)
    ImageButton barMoreBtn;

    @BindView(R.id.bar_text_btn)
    Button barTextBtn;

    private Context mContext;

    private OnClickListener listener;

    public CommonBar(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        LayoutInflater.from(context).inflate(R.layout.widget_commonbar, this);

        @SuppressWarnings("CustomViewStyleable")
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonBar);

        ButterKnife.bind(this);

        if (typedArray.getBoolean(R.styleable.CommonBar_show_more_btn, true)) {
            barMoreBtn.setVisibility(INVISIBLE);
        }

        if (typedArray.getBoolean(R.styleable.CommonBar_show_text_btn, false)) {
            barTextBtn.setVisibility(VISIBLE);
            barTextBtn.setText(typedArray.getText(R.styleable.CommonBar_button_name));
        }

        barTitleText.setText(typedArray.getText(R.styleable.CommonBar_bar_title));

    }

    public void setTextButtonClickListener(OnClickListener listener) {
        barTextBtn.setOnClickListener(listener);
    }

    @OnClick(R.id.bar_return_btn)
    public void onClickBarReturnBtn(View v) {
        ((Activity)getContext()).finish();
    }

    @OnClick(R.id.bar_more_btn)
    public void onClickBarMoreBtn(View v) {

    }
}
