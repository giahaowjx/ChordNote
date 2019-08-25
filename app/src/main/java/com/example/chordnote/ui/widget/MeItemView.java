package com.example.chordnote.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.chordnote.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 自定义控件，表示用户个人信息界面每一项功能的功能项
 * 提高重用性，减少代码量
 */
public class MeItemView extends RelativeLayout {

    private TextView data;
    private CircleImageView head;
    private Context mContext;

    public MeItemView(final Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;

        LayoutInflater.from(context).inflate(R.layout.item_me_menu, this);
        @SuppressLint("CustomViewStyleable")
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MeItemView);

        ImageView icon = findViewById(R.id.icon_img);
        ImageView detail = findViewById(R.id.detail_img);
        ImageView line = findViewById(R.id.line_img);
        TextView name = findViewById(R.id.name_text);
        head = findViewById(R.id.user_info_head_img);
        data = findViewById(R.id.data_text);

        icon.setImageDrawable(typedArray.getDrawable(R.styleable.MeItemView_icon));
        name.setText(typedArray.getText(R.styleable.MeItemView_name));

        if (typedArray.getBoolean(R.styleable.MeItemView_show_detail, false)) {
            detail.setVisibility(VISIBLE);
        }

        if (typedArray.getBoolean(R.styleable.MeItemView_show_line, false)) {
            line.setVisibility(VISIBLE);
        }

        typedArray.recycle();

    }

    /**
     * 如果任务项有数据需要显示，比如用户名项显示用户名可以使用
     * @param data
     */
    public void setData(String data) {
        this.data.setText(data);
    }

    public void setHead(String uri) {
        Glide.with(mContext)
                .load(uri)
                .placeholder(R.drawable.user_head)
                .into(head);
    }

}
