package com.example.chordnote.data.network;

import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.RegisterRequest;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.network.model.CheckCodeResponse;
import com.example.chordnote.utils.AppSetting;
import com.google.gson.Gson;

import javax.inject.Inject;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


public class ApiHelperImpl implements ApiHelper {

//    private ApiHeader mApiHeader;

    private Retrofit retrofit;

    private NetworkService service;

    @Inject
    public ApiHelperImpl() {

        Gson gson = new Gson();

        retrofit = new Retrofit.Builder()
                .baseUrl(AppSetting.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        service = retrofit.create(NetworkService.class);
    }

//    @Override
//    public ApiHeader getApiHeader() {
//        return mApiHeader;
//    }

    @Override
    public LoginResponse doLoginApiCall(LoginRequest.ServerLoginRequest request) {
        return null;
    }

    @Override
    public RegisterResponse doRegisterApiCall(RegisterRequest request) {
        return null;
    }

    @Override
    public Observable<CheckCodeResponse> doSendCheckCodeApiCall(String  email) {

        return service.postCheckCode(email);
    }
}
