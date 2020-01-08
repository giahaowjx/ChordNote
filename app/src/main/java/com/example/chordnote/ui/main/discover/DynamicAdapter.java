package com.example.chordnote.ui.main.discover;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.chordnote.R;
import com.example.chordnote.data.network.model.Dynamic;
import com.example.chordnote.ui.period.PeriodActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class DynamicAdapter extends RecyclerView.Adapter<DynamicAdapter.ViewHolder> {

    private ArrayList<Dynamic> dynamics;
    private Context context;

    public DynamicAdapter(Context context, ArrayList<Dynamic> dynamics){
        this.dynamics = dynamics;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView userNameText;
        private CircleImageView userHeadImg;
        private TextView publishedTimeText;
        private TextView dynamicContentText;
        private TextView numOfGoodText;
        private ImageView dynamicImg;
        private ImageView good;
        private TextView dynamicTitle;

        public ViewHolder(View itemView){
            super(itemView);

            userNameText = itemView.findViewById(R.id.dynamic_user_name);
            userHeadImg = itemView.findViewById(R.id.dynamic_user_head_img);
            publishedTimeText = itemView.findViewById(R.id.dynamic_publish_time);
            dynamicContentText = itemView.findViewById(R.id.dynamic_content);
            numOfGoodText = itemView.findViewById(R.id.dynamic_num_good);
            dynamicImg = itemView.findViewById(R.id.dynamic_image);
            good = itemView.findViewById(R.id.dynamic_good);
            dynamicTitle = itemView.findViewById(R.id.dynamic_title);
        }

        // 设置头像
        void setUserHead(Uri uri, Context context){
            Glide.with(context)
                    .load(uri)
                    .placeholder(R.drawable.user_head)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(userHeadImg);
        }

        // 设置头像
        void setUserHead(String uri, Context context){
            Glide.with(context)
                    .load(uri)
                    .placeholder(R.drawable.user_head)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(userHeadImg);
        }

        // 设置用户名
        void setUserName(String name){
            userNameText.setText(name);
        }

        // 设置发布日期
        void setPublishedTime(String time){
            publishedTimeText.setText(time);
        }

        // 设置动态内容
        void setDynamicContent(String content){
            dynamicContentText.setText(content);
        }

        // 设置动态图片
        void setDynamicImage(String uri, Context context){
            Glide.with(context)
                    .load(uri)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(dynamicImg);
        }

        // 设置动态图片
        void setDynamicImage(Uri uri, Context context){
            Glide.with(context)
                    .load(uri)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(dynamicImg);
        }

        // 设置标题
        void setDynamicTitle(String title){
            dynamicTitle.setText(title);
        }

        // 设置点赞数
        void setNumOfGood(String num){
            numOfGoodText.setText(num);
        }
    }

    // 绑定布局
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dynamic,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // 添加点击事件
    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position){

        holder.setDynamicImage(dynamics.get(position).getHeadImgUrl(),context);
        holder.setUserHead(dynamics.get(position).getHeadImgUrl(), context);
        holder.setUserName(dynamics.get(position).getNickName());
        holder.setPublishedTime(dynamics.get(position).getPublishedTime());
        holder.setNumOfGood(String.valueOf(dynamics.get(position).getLikeNum()));
        holder.setDynamicTitle(dynamics.get(position).getTitle());
        holder.setDynamicContent(dynamics.get(position).getContent());

        holder.good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiscoverFragment.plusGoodNum(dynamics.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount(){
        if (dynamics == null) {
            return 0;
        } else {
            return dynamics.size();
        }

    }
}
