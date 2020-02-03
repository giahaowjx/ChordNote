package com.example.chordnote.ui.collectcomments;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.CommentsResponse;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CollectCommentPresenterImpl<V extends CollectCommentView> extends BasePresenter<V> implements CollectCommentPresenter<V> {

    private static final String TAG = "CollectCommentPresenter";

    @Inject
    public CollectCommentPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void setDynamicList(String email) {
        getDataManager().doGetUserCollectCommentsApiCall(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentsResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(CommentsResponse commentsResponse) {
                        Log.d(TAG, "onNext: ");

                        if (commentsResponse.getCode() == 1000){
                            getMvpView().setDynamicList(commentsResponse.getCommentList());
                        }else{
                            getMvpView().showToastText("获取评论失败！");
                        }
                    }
                });
    }
}
