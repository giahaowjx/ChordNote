package com.example.chordnote.ui.login;


import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.ui.base.BasePresenter;
import com.example.chordnote.utils.NetworkUtils;

import java.util.Map;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class LoginPresenterImpl<V extends LoginView> extends BasePresenter<V> implements LoginPresenter<V> {

    private static final String TAG = "LoginPresenterImpl";

    public LoginPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);
    }

    @Override
    public void Login(Map<String, String> request) {
        getMvpView().showLoading();

        getDataManager().doLoginApiCall(NetworkUtils.generateRegisterRequestBody(request))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ChordNote");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ChordNote");
                    }

                    @Override
                    public void onNext(LoginResponse loginResponse) {
                        
                        int code = loginResponse.getStatusCode();

                        if (code == 1001) {
                            getMvpView().showToastText("用户名或密码错误");
                        } else if (code == 1000) {
                            getMvpView().showToastText("登陆成功");


                        }
                    }
                });

        getMvpView().hideLoading();
    }

}
