package com.example.chordnote.ui.userinfo;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.db.model.User;
import com.example.chordnote.data.network.model.UserInformationResponse;
import com.example.chordnote.ui.base.BasePresenter;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class UserInfoPresenterImpl<V extends UserInfoView> extends BasePresenter<V>
        implements UserInfoPresenter<V> {

    private static final String TAG = "UserInfoPresenterImpl";

    public UserInfoPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void getUserInfo() {
        if (getMvpView().isConnected()) {
            getDataManager().doGetUserInformationApiCall(getDataManager().getCurrentUserEmail())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<UserInformationResponse>() {
                        @Override
                        public void onCompleted() {
                            Log.d(TAG, "onCompleted: ");
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.d(TAG, "onError: ");
                        }

                        @Override
                        public void onNext(UserInformationResponse userInformationResponse) {
                            Log.d(TAG, "onNext: ");

                            // 将获取的信息设置到界面上
                            User user = userInformationResponse.getUserInformation();

                            getMvpView().setUserUri(user.getImageUrl());
                            getMvpView().setUserName(user.getUserName());
                            getMvpView().setUserEmail(user.getEmail());
                            getMvpView().setUserSex(user.getSex());
                            getMvpView().setUserBirthDate(user.getBirthDate());
                            getMvpView().setUserDescription(user.getDescription());
                        }
                    });
        }
    }

    @Override
    public void resetLoginState() {

    }
}
