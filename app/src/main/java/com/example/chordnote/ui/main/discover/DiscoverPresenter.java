package com.example.chordnote.ui.main.discover;

import com.example.chordnote.ui.base.MvpPresenter;

public interface DiscoverPresenter<V extends DiscoverView> extends MvpPresenter<V> {

    // 获得动态
    void getDynamics();

    // 发布动态
    void sendDynamic(String email, String title, String content);

    // 删除动态
    void deleteDynamic(int idDynamic);

    // 点赞动态
    void likeDynamic(int idDynamic);

    // 取消点赞动态
    void cancelLikeDynamic(int idDynamic);

    // 收藏动态
    void collectDynamic(int idDynamic, String email);

    // 取消收藏动态
    void cancelCollectDynamic(int idDynamic, String email);

    void plusGoodNum(int id);

}
