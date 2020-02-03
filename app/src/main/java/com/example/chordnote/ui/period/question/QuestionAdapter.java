package com.example.chordnote.ui.period.question;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.chordnote.R;
import com.example.chordnote.data.network.model.Question;

import org.greenrobot.greendao.annotation.NotNull;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private ArrayList<Question> questions;
    private Context context;

    public QuestionAdapter(Context context, ArrayList<Question> questions){
        this.questions = questions;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView questionCard;
        private TextView stemText;
        private ImageView questionImg;

        private Button optionABtn;
        private TextView optionAText;

        private Button optionBBtn;
        private TextView optionBText;

        private Button optionCBtn;
        private TextView optionCText;

        private Button optionDBtn;
        private TextView optionDText;

        public ViewHolder(View itemView){
            super(itemView);

            questionCard = itemView.findViewById(R.id.question_card);
            stemText = itemView.findViewById(R.id.question_stem);
            questionImg = itemView.findViewById(R.id.question_img);

            optionABtn = itemView.findViewById(R.id.option_A_btn);
            optionAText = itemView.findViewById(R.id.option_A_txt);

            optionBBtn = itemView.findViewById(R.id.option_B_btn);
            optionBText = itemView.findViewById(R.id.option_B_txt);

            optionCBtn = itemView.findViewById(R.id.option_C_btn);
            optionCText = itemView.findViewById(R.id.option_C_txt);

            optionDBtn = itemView.findViewById(R.id.option_D_btn);
            optionDText = itemView.findViewById(R.id.option_D_txt);
        }

        // 设置题干
        void setStemText(String stemString){
            stemText.setText(stemString);
        }

        // 设置题目图片
        void setQuestionImg(String uri,Context context){
            Glide.with(context)
                    .load(uri)
                    .placeholder(R.drawable.user_head)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(questionImg);
        }

        // 设置题目选项A内容
        void setOptionAText(String str){
            optionAText.setText(str);
        }

        // 设置题目选项B内容
        void setOptionBText(String str){
            optionBText.setText(str);
        }

        // 设置题目选项C内容
        void setOptionCText(String str){
            optionCText.setText(str);
        }

        // 设置题目选项D内容
        void setOptionDText(String str){
            optionDText.setText(str);
        }
    }

    // 绑定布局
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_question,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    // 添加点击事件
    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position){
        holder.setStemText(questions.get(position).getStem());
        if (questions.get(position).getImgUrl() != null){
            holder.setQuestionImg(questions.get(position).getImgUrl(), context);
        }
        holder.setOptionAText(questions.get(position).getOptionList().get(0).getContent());
        holder.setOptionBText(questions.get(position).getOptionList().get(1).getContent());
        holder.setOptionCText(questions.get(position).getOptionList().get(2).getContent());
        holder.setOptionDText(questions.get(position).getOptionList().get(3).getContent());

        // 设置点击事件
        holder.optionABtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getBackground() == view.getResources().getDrawable(R.drawable.option_shape_normal)){
                    view.setBackgroundResource(R.drawable.option_shape_pressed);
                }else{
                    view.setBackgroundResource(R.drawable.option_shape_normal);
                }
            }
        });

        holder.optionBBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getBackground() == view.getResources().getDrawable(R.drawable.option_shape_normal)){
                    view.setBackgroundResource(R.drawable.option_shape_pressed);
                }else{
                    view.setBackgroundResource(R.drawable.option_shape_normal);
                }
            }
        });

        holder.optionCBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getBackground() == view.getResources().getDrawable(R.drawable.option_shape_normal)){
                    view.setBackgroundResource(R.drawable.option_shape_pressed);
                }else{
                    view.setBackgroundResource(R.drawable.option_shape_normal);
                }
            }
        });

        holder.optionDBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getBackground() == view.getResources().getDrawable(R.drawable.option_shape_normal)){
                    view.setBackgroundResource(R.drawable.option_shape_pressed);
                }else{
                    view.setBackgroundResource(R.drawable.option_shape_normal);
                }
            }
        });
    }

    @Override
    public int getItemCount(){
        if (questions == null) {
            return 0;
        } else {
            return questions.size();
        }

    }

}
