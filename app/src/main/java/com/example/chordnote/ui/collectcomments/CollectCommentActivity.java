package com.example.chordnote.ui.collectcomments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.chordnote.R;
import com.example.chordnote.data.network.model.Comment;
import com.example.chordnote.ui.base.BaseActivity;
import com.example.chordnote.ui.period.comment.CommentAdapter;
import com.example.chordnote.ui.widget.CommonBar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CollectCommentActivity extends BaseActivity implements CollectCommentView {

    @Inject
    CollectCommentPresenter<CollectCommentView> presenter;

    private String email;

    private ArrayList<Comment> comments;

    @BindView(R.id.collect_comment_list_view)
    RecyclerView collectComments;

    @BindView(R.id.collect_comment_commonbar)
    CommonBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect_comment);

        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        presenter.onAttach(this);

        collectComments.setLayoutManager(new LinearLayoutManager(this));

        email = getIntent().getStringExtra("email");
        if (email != null){
            presenter.setDynamicList(email);
        }

        getSupportActionBar().hide();

        bar.setBarTitleText("收藏评论");
    }

    public static Intent getIntent(Context context, String email){
        Intent intent = new Intent(context, CollectCommentActivity.class);

        intent.putExtra("email", email);

        return intent;
    }

    @Override
    public void setDynamicList(ArrayList<Comment> comments) {
        this.comments = comments;

        collectComments.setAdapter(new CommentAdapter(this, comments));
    }
}
