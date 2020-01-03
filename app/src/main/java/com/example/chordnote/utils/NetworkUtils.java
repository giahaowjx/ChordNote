package com.example.chordnote.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public final class NetworkUtils {

    public static final String IMAGE = "image/*";

    public static Map<String, RequestBody> generateRegisterRequestBody(Map<String, String> data) {
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        for (String key : data.keySet()) {
            String body = data.get(key);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), body);

            requestBodyMap.put(key, requestBody);

        }
        return requestBodyMap;
    }


    public static MultipartBody.Part generateMultipartBody(File data, String name, String type) {

        RequestBody requestBody =  RequestBody.create(MediaType.parse(type), data);

        return MultipartBody.Part.createFormData(name, data.getName(), requestBody);

    }

    /**
     * 判断是否联网
     * @param context
     * @return 联网状态
     */
    public static boolean isNetWorkAvailable(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo.isConnected();
    }
}
