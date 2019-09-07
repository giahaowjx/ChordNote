package com.example.chordnote.ui.main.me;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.db.model.User;
import com.example.chordnote.data.network.model.UserInformation;
import com.example.chordnote.data.network.model.UserInformationResponse;
import com.example.chordnote.ui.base.BasePresenter;
import com.example.chordnote.utils.NetworkUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MePresenterImpl<V extends MeView> extends BasePresenter<V> implements MePresenter<V> {

    private static final String TAG = "MePresenterImpl";

    @Inject
    public MePresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void goNextActivity() {
        if (!getDataManager().getCurrentLoginState()) {
            getMvpView().openLoginActivity();
        } else {
            getMvpView().openUserInfoActivity();
        }
    }

    @Override
    public void showUserBriefInfo() {
        if (getDataManager().getCurrentLoginState()) {
            // 登陆情况下，判断是否有网络，有网络通过网络获取用户信息

            Log.d(TAG, "showUserBriefInfo: " + getMvpView().isConnected());

            if (getMvpView().isConnected()) {

                Log.d(TAG, "showUserBriefInfo: Connected");

                Map<String, String> requestBody = new HashMap<>();

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

                                User user = userInformationResponse.getUserInformation();

                                // 插入或修改本地存储的用户数据
                                long id = getDataManager().getIdUsingEmail(user.getEmail());
                                if (id == 0) {
                                    // 若id为0，说明该用户是第一次在该设备登陆，保存用户信息并保存映射关系
                                    id = getDataManager().insertUser(user);
                                    getDataManager().setEmailToIdMap(user.getEmail(), id);
                                } else {
                                    // 若不为0则用户在该设备登陆过，修改用户数据
                                    user.setId(id);
                                    getDataManager().insertUser(user);
                                }

                                getDataManager().setCurrentUserNickName(user.getUserName());
                                getMvpView().changeUserInfoView(user.getUserName(), user.getImageUrl());

                                Log.d(TAG, "onNext: " + user.getUserName());
                            }
                        });
            } else {
                List<User> user = getDataManager().getUser(getDataManager().getCurrentUserEmail());

                if (user.size() != 1) {
                    Log.d(TAG, "showUserBriefInfo: " + "存在多个相同邮箱用户");
                    return;
                }

                getMvpView().changeUserInfoView(user.get(0).getUserName(), user.get(0).getImageUrl());

            }
        }
    }
}
