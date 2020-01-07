package com.example.chordnote.ui.period;

import com.example.chordnote.ui.base.MvpPresenter;

public interface PeriodPresenter<V extends PeriodView> extends MvpPresenter<V> {

    // 获得课时内容
    void getPeriodInfo(int idPeriod);

    // 获得课时习题
    void getQuestions(int idPeriod);

    // 获得课时评论
    void getComments(int idPeriod);

    // 发布评论
    void sendComment(int idPeriod, String email, String content);

    // 删除评论
    void deleteComment(int idPeriod);

    // 收藏评论
    void collectComment(int idComment, String email);

    // 取消收藏评论
    void cancelCollectComment(int idComment, String email);
}
