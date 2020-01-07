package com.example.chordnote.ui.period;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.CommentsResponse;
import com.example.chordnote.data.network.model.CommonResponse;
import com.example.chordnote.data.network.model.PeriodResponse;
import com.example.chordnote.data.network.model.QuestionsResponse;
import com.example.chordnote.ui.base.BasePresenter;
import com.example.chordnote.utils.NetworkUtils;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class PeriodPresenterImpl<V extends PeriodView> extends BasePresenter<V> implements PeriodPresenter<V> {

    private static final String TAG = "PeriodPresenterImpl";

    @Inject
    public PeriodPresenterImpl(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void getPeriodInfo(int idPeriod) {
        getDataManager().doGetPeriodInfoApiCall(idPeriod)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PeriodResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(PeriodResponse periodResponse) {
                        Log.d(TAG, "onNext: ");
                        // TODO
                    }
                });
    }

    @Override
    public void getQuestions(int idPeriod) {
        getDataManager().doGetQuestionsApiCall(idPeriod)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<QuestionsResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(QuestionsResponse questionsResponse) {
                        Log.d(TAG, "onNext: ");
                    }
                });
    }

    @Override
    public void getComments(int idPeriod) {
        getDataManager().doGetCommentsApiCall(idPeriod)
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
                        // TODO
                    }
                });
    }

    @Override
    public void sendComment(int idPeriod, String email, String content) {
        Map<String, String> request = new HashMap<>();

        request.put("id_period", String.valueOf(idPeriod));
        request.put("email", email);
        request.put("content", content);


        getDataManager().doPostCommentApiCall(NetworkUtils.generateRegisterRequestBody(request))
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
    public void deleteComment(int idPeriod) {
        getDataManager().doDeleteCommentApiCall(idPeriod)
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
    public void collectComment(int idComment, String email) {
        getDataManager().doPostCollectCommentApiCall(idComment, email)
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
    public void cancelCollectComment(int idComment, String email) {
        getDataManager().doDeleteCollectCommentApiCall(idComment, email)
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
}
