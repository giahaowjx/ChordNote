package com.example.chordnote.data;

import com.example.chordnote.data.network.ApiHelper;
import com.example.chordnote.data.network.model.CheckCodeResponse;
import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.RegisterRequest;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.prefs.PreferencesHelper;

import rx.Observable;

public class DataManager implements DataManagerApi {

    private PreferencesHelper preferencesHelper;

    private ApiHelper apiHelper;

    public DataManager(PreferencesHelper preferencesHelper, ApiHelper apiHelper) {
        this.preferencesHelper = preferencesHelper;
        this.apiHelper = apiHelper;
    }

    // PreferencesHelper Interface
    @Override
    public boolean getCurrentLoginState() {
        return preferencesHelper.getCurrentLoginState();
    }

    @Override
    public void setCurrentLoginState(boolean state) {
        preferencesHelper.setCurrentLoginState(state);
    }

    @Override
    public Long getCurrentUserId() {
        return preferencesHelper.getCurrentUserId();
    }

    @Override
    public void setCurrentUserId(Long id) {
        preferencesHelper.setCurrentUserId(id);
    }

    // ApiHelper interface
    public LoginResponse doLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return apiHelper.doLoginApiCall(request);
    }

    public RegisterResponse doRegisterApiCall(RegisterRequest request) {
        return apiHelper.doRegisterApiCall(request);
    }

    public Observable<CheckCodeResponse> doSendCheckCodeApiCall(String email) {
        return apiHelper.doSendCheckCodeApiCall(email);
    }

}
