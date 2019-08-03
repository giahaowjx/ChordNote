package com.example.chordnote.utils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

public final class NetworkUtils {

    public static Map<String, RequestBody> generateRegisterRequestBody(Map<String, String> data) {
        Map<String, RequestBody> requestBodyMap = new HashMap<>();
        for (String key : data.keySet()) {
            String body = data.get(key);
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), body);

            requestBodyMap.put(key, requestBody);

        }
        return requestBodyMap;
    }

}
