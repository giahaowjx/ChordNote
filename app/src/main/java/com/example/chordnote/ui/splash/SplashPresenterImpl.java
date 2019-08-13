package com.example.chordnote.ui.splash;

import com.example.chordnote.data.DataManager;
import com.example.chordnote.ui.base.BasePresenter;

import javax.inject.Inject;

public class SplashPresenterImpl<V extends SplashView> extends BasePresenter<V> implements SplashPresenter<V> {

    @Inject
    public SplashPresenterImpl(DataManager manager) {
        super(manager);
    }

    @Override
    public void onAttach(V view) {
        super.onAttach(view);

        // 可以加入线程放动画

        getMvpView().openMainActivity();

    }

}
