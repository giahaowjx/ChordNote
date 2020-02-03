package com.example.chordnote.ui.mydynamics;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.DynamicsResponse;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MyDynamicPresenterImpl<V extends MyDynamicView> extends BasePresenter<V> implements MyDynamicPresenter<V> {

    private static final String TAG = "MyDynamicPresenterImpl";

    @Inject
    public MyDynamicPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void setDynamicList(String email) {
        getDataManager().doGetUserDynamicsApiCall(email)
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
                        }else{
                            getMvpView().showToastText("获取用户动态失败！");
                        }
                    }
                });
    }
}
