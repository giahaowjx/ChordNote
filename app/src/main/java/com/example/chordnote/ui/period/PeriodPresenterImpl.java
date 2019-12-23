package com.example.chordnote.ui.period;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.CommentsResponse;
import com.example.chordnote.data.network.model.PeriodResponse;
import com.example.chordnote.data.network.model.QuestionsResponse;
import com.example.chordnote.ui.base.BasePresenter;

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
//        Map<String>
//
//        getDataManager().doPostCommentApiCall()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<CommentsResponse>() {
//                    @Override
//                    public void onCompleted() {
//                        Log.d(TAG, "onCompleted: ");
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "onError: ");
//                    }
//
//                    @Override
//                    public void onNext(CommentsResponse commentsResponse) {
//                        Log.d(TAG, "onNext: ");
//                        // TODO
//                    }
//                });
    }

    @Override
    public void deleteComment(int idPeriod) {

    }

    @Override
    public void collectComment(int idPeriod, String email) {

    }

    @Override
    public void cancelCollectComment(int idPeriod, String email) {

    }
}
