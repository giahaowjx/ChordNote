package com.example.chordnote.ui.period.comment;

import android.content.Context;
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
import com.example.chordnote.data.network.model.Comment;
import com.example.chordnote.data.network.model.Dynamic;
import com.example.chordnote.ui.main.discover.DiscoverFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private ArrayList<Comment> comments;
    private Context context;

    public CommentAdapter(Context context, ArrayList<Comment> comments){
        this.comments = comments;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView userNameText;
        private CircleImageView userHeadImg;
        private TextView publishedTimeText;
        private TextView commentContentText;
        private TextView numOfGoodText;
        private ImageView commentImg;
        private ImageView good;

        public ViewHolder(View itemView){
            super(itemView);

            userNameText = itemView.findViewById(R.id.comment_user_name);
            userHeadImg = itemView.findViewById(R.id.comment_user_head_img);
            publishedTimeText = itemView.findViewById(R.id.comment_publish_time);
            commentContentText = itemView.findViewById(R.id.comment_content);
            numOfGoodText = itemView.findViewById(R.id.comment_num_good);
            commentImg = itemView.findViewById(R.id.comment_image);
            good = itemView.findViewById(R.id.comment_good);
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
        void setCommentContent(String content){
            commentContentText.setText(content);
        }

        // 设置动态图片
        void setCommentImage(String uri, Context context){
            Glide.with(context)
                    .load(uri)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(commentImg);
        }

        // 设置动态图片
        void setCommentImage(Uri uri, Context context){
            Glide.with(context)
                    .load(uri)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(commentImg);
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // 添加点击事件
    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position){

        holder.setCommentImage(comments.get(position).getHeadImgUrl(),context);
        holder.setUserHead(comments.get(position).getHeadImgUrl(), context);
        holder.setUserName(comments.get(position).getNickName());
        holder.setPublishedTime(comments.get(position).getPublishedTime());
        holder.setNumOfGood(String.valueOf(comments.get(position).getLikeNum()));
        holder.setCommentContent(comments.get(position).getContent());

        holder.good.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DiscoverFragment.plusGoodNum(comments.get(position).getIdComment());
            }
        });
    }

    @Override
    public int getItemCount(){
        if (comments == null) {
            return 0;
        } else {
            return comments.size();
        }

    }
}
