package com.example.chordnote.ui.collectdynamics;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.CommentsResponse;
import com.example.chordnote.data.network.model.DynamicsResponse;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CollectDynamicPresenterImpl<V extends CollectDynamicView> extends BasePresenter<V> implements CollectDynamicPresenter<V> {

    private static final String TAG = "CollectDynamicPresenter";

    @Inject
    public CollectDynamicPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void setDynamicList(String email) {
        getDataManager().doGetUserCollectDynamicsApiCall(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DynamicsResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(DynamicsResponse dynamicsResponse) {
                        Log.d(TAG, "onNext: ");

                        if (dynamicsResponse.getCode() == 1000){
                            getMvpView().setDynamicList(dynamicsResponse.getUserDynamicList());
                        }else {
                            getMvpView().showToastText("获取动态失败！");
                        }
                    }
                });
    }
}
