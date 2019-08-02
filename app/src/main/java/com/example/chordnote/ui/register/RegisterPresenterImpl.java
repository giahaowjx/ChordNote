package com.example.chordnote.ui.register;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.CheckCodeResponse;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RegisterPresenterImpl<V extends RegisterView> extends BasePresenter<V> implements RegisterPresenter<V> {

    private static final String TAG = "RegisterPresenterImpl";

    @Inject
    public RegisterPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }

    @Override
    public void sendCheckCode(String email) {

        getMvpView().showLoading();

        getDataManager().doSendCheckCodeApiCall(email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CheckCodeResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: failed");
                    }

                    @Override
                    public void onNext(CheckCodeResponse checkCodeResponse) {

                        if (checkCodeResponse.getStatusCode() != 1000) {
                            getMvpView().showToastText("验证码发送失败，请重试");
                        } else {
                            getMvpView().showToastText("发送成功");
                        }

                        Log.d(TAG, "onNext: " + checkCodeResponse.getMessage());
                    }
                });

        getMvpView().hideLoading();

    }

    @Override
    public void register(String email, String name, String password) {

    }

}
