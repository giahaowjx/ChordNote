package com.example.chordnote.ui.booklist;

import android.util.Log;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.data.network.model.BookListResponse;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BookListPresenterImpl<V extends BookListView> extends BasePresenter<V> implements BookListPresenter<V> {

    private static final String TAG = "BookListPresenterImpl";

    @Inject
    public BookListPresenterImpl(DataManager manager) {
        super(manager);
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

                        if (bookListResponse.getCode() == 1000){
                            getMvpView().setBookList(bookListResponse.getBookList());
                        }else{
                            getMvpView().showToastText("获取书本列表失败！");
                        }
                    }
                });
    }
}
