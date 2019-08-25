package com.example.chordnote.data.network;

import com.example.chordnote.data.network.model.CheckCodeResponse;
import com.example.chordnote.data.network.model.LoginResponse;
import com.example.chordnote.data.network.model.RegisterRequest;
import com.example.chordnote.data.network.model.RegisterResponse;
import com.example.chordnote.data.network.model.UserInformationResponse;

import java.util.Map;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworkService {

    @GET("register/")
    Observable<CheckCodeResponse> getCheckCode(@Query("email") String email);

    @Multipart
    @POST("register/")
    Observable<RegisterResponse> postRegisterRequest(@PartMap Map<String, RequestBody> requestBodyMap);

    @Multipart
    @POST("auth/")
    Observable<LoginResponse> postLoginRequest(@PartMap Map<String, RequestBody> requestBodyMap);

    @GET("user_information/")
    Observable<UserInformationResponse> getUserInformationRequest(@Query("email") String email);

}
