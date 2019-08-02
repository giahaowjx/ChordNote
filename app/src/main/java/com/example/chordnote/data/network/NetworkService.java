package com.example.chordnote.data.network;

import com.example.chordnote.data.network.model.CheckCodeResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface NetworkService {

    @GET("register/")
    Observable<CheckCodeResponse> postCheckCode(@Query("email") String email);

}
