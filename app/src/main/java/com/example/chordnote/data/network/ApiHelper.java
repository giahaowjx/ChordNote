package com.example.chordnote.data.network;

import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.network.model.CheckCodeResponse;

import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;


public interface ApiHelper {

//    ApiHeader getApiHeader();

    Observable<LoginResponse> doLoginApiCall(Map<String, RequestBody> requestBodyMap);

    Observable<RegisterResponse> doRegisterApiCall(Map<String, RequestBody> request);

    Observable<CheckCodeResponse> doSendCheckCodeApiCall(String  email);

}
