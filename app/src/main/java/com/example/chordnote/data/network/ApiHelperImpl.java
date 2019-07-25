package com.example.chordnote.data.network;

import com.example.chordnote.data.network.model.LoginRequest;
import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.RegisterRequest;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.network.model.ValidateCodeRequest;
import com.example.chordnote.data.network.model.ValidateCodeResponse;

import javax.inject.Inject;

public class ApiHelperImpl implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public ApiHelperImpl(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public LoginResponse doLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return null;
    }

    @Override
    public RegisterResponse doRegisterApiCall(RegisterRequest request) {
        return null;
    }

    @Override
    public ValidateCodeResponse doSendValidateCodeApiCall(ValidateCodeRequest request) {
        return null;
    }
}
