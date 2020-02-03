package com.example.chordnote.ui.main.study;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.BookListResponse;
import com.example.chordnote.data.network.model.ChapterListResponse;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class StudyPresenterImpl<V extends StudyView> extends BasePresenter<V> implements StudyPresenter<V> {

    private static final String TAG = "StudyPresenterImpl";
    
    @Inject
    public StudyPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void refresh() {
        return;
    }

    @Override
    public void getBookList() {
        getDataManager().doGetBookListApiCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookListResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(BookListResponse bookListResponse) {
                        Log.d(TAG, "onNext: ");
                        // TODO
                    }
                });
    }

    @Override
    public void getChapterList(int idBook) {
        getDataManager().doGetChapterListApiCall(idBook)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChapterListResponse>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG, "onCompleted: ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: ");
                    }

                    @Override
                    public void onNext(ChapterListResponse chapterListResponse) {
                        Log.d(TAG, "onNext: ");

                        if (chapterListResponse.getCode() == 1000){
                            getMvpView().setChapterList(chapterListResponse.getChapterList());
                        }else{
                            getMvpView().showToastText("获取目录失败！");
                        }
                    }
                });
    }
}
