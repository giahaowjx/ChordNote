package com.example.chordnote.ui.period.question;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.QuestionsResponse;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class QuestionPresenterImpl<V extends QuestionView> extends BasePresenter<V> implements QuestionPresenter<V> {

    private static final String TAG = "QuestionPresenterImpl";

    @Inject
    public QuestionPresenterImpl(DataManager manager){
        super(manager);
    }


    @Override
    public void setQuestionList(int idPeriod) {
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

                        if (questionsResponse.getCode() == 1000){
                            getMvpView().setQuestionList(questionsResponse.getQuestionList());
                        }else{
                            getMvpView().showToastText("获取问题失败");
                        }
                    }
                });
    }
}
