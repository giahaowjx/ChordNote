package com.example.chordnote.data.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.inject.Inject;

public class ApiHeader {

    private ProtectedApiHeader mProtectedApiHeader;

    @Inject
    public ApiHeader(ProtectedApiHeader protectedApiHeader) {
        mProtectedApiHeader = protectedApiHeader;
    }

    public ProtectedApiHeader getmProtectedApiHeader() {
        return mProtectedApiHeader;
    }

    public static final class ProtectedApiHeader {

        @Expose
        @SerializedName("token")
        private String mAccessToken;

        public ProtectedApiHeader(String token) {
            mAccessToken = token;
        }

        public String getmAccessToken() {
            return mAccessToken;
        }

        public void setmAccessToken(String mAccessToken) {
            this.mAccessToken = mAccessToken;
        }
    }

}
