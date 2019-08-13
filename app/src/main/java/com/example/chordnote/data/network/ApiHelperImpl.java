package com.example.chordnote.data.network;

import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.network.model.CheckCodeResponse;
import com.example.chordnote.utils.AppSetting;

import java.util.Map;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;


public class ApiHelperImpl implements ApiHelper {

//    private ApiHeader mApiHeader;

    private static final String TAG = "ApiHelperImpl";

    private Retrofit retrofit;

    private NetworkService service;

    @Inject
    public ApiHelperImpl() {

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);


        retrofit = new Retrofit.Builder()
                .baseUrl(AppSetting.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();

        service = retrofit.create(NetworkService.class);
    }

//    @Override
//    public ApiHeader getApiHeader() {
//        return mApiHeader;
//    }

    @Override
    public Observable<LoginResponse> doLoginApiCall(Map<String, RequestBody> requestBodyMap) {
        return service.postLoginRequest(requestBodyMap);
    }

    @Override
    public Observable<RegisterResponse> doRegisterApiCall(Map<String, RequestBody> requestBodyMap) {

        return service.postRegisterRequest(requestBodyMap);
    }

    @Override
    public Observable<CheckCodeResponse> doSendCheckCodeApiCall(String  email) {

        return service.getCheckCode(email);
    }

}
