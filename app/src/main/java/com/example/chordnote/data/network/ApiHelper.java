package com.example.chordnote.data.network;

import com.example.chordnote.data.network.model.LoginRequest;
import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.RegisterRequest;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.network.model.ValidateCodeRequest;
import com.example.chordnote.data.network.model.ValidateCodeResponse;

public interface ApiHelper {

    ApiHeader getApiHeader();

    LoginResponse doLoginApiCall(LoginRequest.ServerLoginRequest request);

    RegisterResponse doRegisterApiCall(RegisterRequest request);

    ValidateCodeResponse doSendValidateCodeApiCall(ValidateCodeRequest request);

}
