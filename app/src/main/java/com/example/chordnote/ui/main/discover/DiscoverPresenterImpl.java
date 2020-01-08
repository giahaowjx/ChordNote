package com.example.chordnote.ui.main.discover;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.CommonResponse;
<<<<<<< Updated upstream
import com.example.chordnote.data.network.model.DynamicsResponse;
=======
>>>>>>> Stashed changes
import com.example.chordnote.ui.base.BasePresenter;
import com.example.chordnote.utils.NetworkUtils;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DiscoverPresenterImpl<V extends DiscoverView> extends BasePresenter<V> implements DiscoverPresenter<V> {

    private static final String TAG = "DiscoverPresenterImpl";
<<<<<<< Updated upstream

=======
    
>>>>>>> Stashed changes
    @Inject
    public DiscoverPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
<<<<<<< Updated upstream
    public void getDynamics() {
        getDataManager().doGetDynamicsApiCall()
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

                        // TODO
                    }
                });
    }

    @Override
    public void sendDynamic(String email, String title, String content) {
        Map<String, String> request = new HashMap<>();

        request.put("email", email);
        request.put("title", title);
        request.put("content", content);

        getDataManager().doPostDynamicApiCall(NetworkUtils.generateRegisterRequestBody(request), null, null)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommonResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {
                        Log.d(TAG, "onNext: ");

                        // TODO
                    }
                });
    }

    @Override
    public void deleteDynamic(int idDynamic) {
        getDataManager().doDeleteDynamicApiCall(idDynamic)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommonResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {
                        Log.d(TAG, "onNext: ");

                        // TODO
                    }
                });
    }

    @Override
    public void likeDynamic(int idDynamic) {
        getDataManager().doPutLikeDynamicApiCall(idDynamic)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommonResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {
                        Log.d(TAG, "onNext: ");

                        // TODO
                    }
                });
    }

    @Override
    public void cancelLikeDynamic(int idDynamic) {
        getDataManager().doPutCancelLikeDynamicApiCall(idDynamic)
=======
    public void plusGoodNum(int id) {
        getDataManager().doPutLikeDynamicApiCall(id)
>>>>>>> Stashed changes
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommonResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {
                        Log.d(TAG, "onNext: ");
<<<<<<< Updated upstream

                        // TODO
                    }
                });

    }

    @Override
    public void collectDynamic(int idDynamic, String email) {
        getDataManager().dpPutCollectDynamicApiCall(idDynamic, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommonResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {
                        Log.d(TAG, "onNext: ");

                        // TODO
                    }
                });
    }

    @Override
    public void cancelCollectDynamic(int idDynamic, String email) {
        getDataManager().doPutCancelCollectDynamicApiCall(idDynamic, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommonResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(CommonResponse commonResponse) {
                        Log.d(TAG, "onNext: ");

                        // TODO
=======
>>>>>>> Stashed changes
                    }
                });
    }
}
